package com.tlf.ExpenseShare.Service;

import com.tlf.ExpenseShare.Model.Expense;
import com.tlf.ExpenseShare.Model.Group;
import com.tlf.ExpenseShare.Model.GroupParticipants;
import com.tlf.ExpenseShare.Model.Transaction;
import com.tlf.ExpenseShare.Repository.ExpenseRepository;
import com.tlf.ExpenseShare.Repository.GroupParticipantRepository;
import com.tlf.ExpenseShare.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final TransactionRepository transactionRepository;
    private final GroupParticipantRepository groupParticipantRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, TransactionRepository transactionRepository, GroupParticipantRepository groupParticipantRepository) {
        this.expenseRepository = expenseRepository;
        this.transactionRepository = transactionRepository;
        this.groupParticipantRepository = groupParticipantRepository;
    }

    public Expense createExpense(@RequestBody Expense expense) {
//        System.out.println(expense.getDescription());
        expenseRepository.save(expense);
        List<GroupParticipants> groupParticipantsList = getGroupParticipantsForGroup(expense.getGroup().getGroupId());
        int size = groupParticipantsList.size();
        for (GroupParticipants groupParticipants : groupParticipantsList) {
            if(expense.getUser().getUserId()!=groupParticipants.getUser().getUserId()) {
                Transaction transaction = new Transaction();
                transaction.setAmount(expense.getAmount()/size); // Set the transaction amount
                transaction.setUserFrom(expense.getUser()); // Set the user who paid the expense
                transaction.setUserTo(groupParticipants.getUser()); // Set the user who owes the expense
                transaction.setExpense(expense); // Set the associated expense
                transaction.setGroup(expense.getGroup()); // Set the associated group
                // Save the transaction
                transactionRepository.save(transaction);
            }
        }
        return expense;
    }
    public List<Expense> getSpecificExpense(int id){
//        return groupRepository.findByCreatorId(id);
        List<Expense> expenseListList = expenseRepository.findAll();
        List<Expense> filteredExpense = new ArrayList<>();

        for (Expense expense : expenseListList) {
            if (expense.getGroup().getGroupId() == id) {
                filteredExpense.add(expense);  // Add the group to the filtered list if the condition is met
            }
        }

        return filteredExpense;
    }

    public List<GroupParticipants> getGroupParticipantsForGroup(int groupId) {
        // Use the groupParticipantRepository to retrieve group participants based on the group ID
        List<GroupParticipants> allParticipants = groupParticipantRepository.findAll();
        List<GroupParticipants> returnList = new ArrayList<>();
        for (GroupParticipants allParticipant : allParticipants) {
            if(allParticipant.getGroup().getGroupId() == groupId){
                returnList.add(allParticipant);
            }
        }
        return returnList;
    }
}
