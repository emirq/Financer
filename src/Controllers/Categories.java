package Controllers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benjaminfajic
 */
public class Categories {
    private List<String> categoriesIncome = new ArrayList<String>();
    private List<String> categoriesExpense = new ArrayList<String>();
    private String name;
    
    public Categories() {
        categoriesIncomeInitialize();
        categoriesExpenseInitialize();
    }
    
    private void categoriesIncomeInitialize() {
        categoriesIncome.add("Salary");
        categoriesIncome.add("Pocket money");
    }
    
    private void categoriesExpenseInitialize() {
        categoriesExpense.add("Car");
        categoriesExpense.add("Clothing");
        categoriesExpense.add("Education");
        categoriesExpense.add("Food");
        categoriesExpense.add("Fuel");
        categoriesExpense.add("Gifts");
        categoriesExpense.add("Phone");   
    }
    
    void addIncomeCategory(String newCategory) {
        String tempCategory = "";
        for(int i = 0; i < categoriesIncome.size(); i++) {
            tempCategory = categoriesIncome.get(i);
            if (tempCategory.equals(newCategory)) {
                System.out.println("Ima već");
                break;
            } 
        }
        if (!tempCategory.equals(newCategory)) {
            categoriesIncome.add(newCategory);
        }
    }
    
    void addExpenseCategory(String newCategory) {
        String tempCategory = "";
        for(int i = 0; i < categoriesExpense.size(); i++) {
            tempCategory = categoriesExpense.get(i);
            if (tempCategory.equals(newCategory)) {
                System.out.println("Ima već");
                break;
            } 
        }
        if (!tempCategory.equals(newCategory)) {
            categoriesExpense.add(newCategory);
        }
    }
    
    void removeIncomeCategory(String removeCategory) {
        for(int i = 0; i < categoriesIncome.size(); i++) {
            String tempCategory = categoriesIncome.get(i);
            if (tempCategory.equals(removeCategory)) {
                categoriesIncome.remove(i);
            }
        }
    }
    
    void removeExpenseCategory(String removeCategory) {
        for(int i = 0; i < categoriesExpense.size(); i++) {
            String tempCategory = categoriesExpense.get(i);
            if(tempCategory.equals(removeCategory)) {
                categoriesExpense.remove(i);
            }
        }
    }
    
    public List<String> getIncomeCategories() {
        return categoriesIncome;
    }
    
    public List<String> getExpenseCategories() {
        return categoriesExpense;
    }
    
    public String incomeToString() {
        String tempString = "";
        for(int i = 0; i < categoriesIncome.size(); i++) {
            tempString += "\n" + categoriesIncome.get(i);
        }
        return (tempString);
    }
    
    public String expenseToString() {
        String tempString = "";
        for(int i = 0; i < categoriesExpense.size(); i++) {
            tempString += "\n" + categoriesExpense.get(i);
        }
        return (tempString);
    }
}
