package com.ciclo3.TodoCompleto.Controllers;

import com.ciclo3.TodoCompleto.Models.Enum_RoleTransaction;
import com.ciclo3.TodoCompleto.Models.Transaction;
import com.ciclo3.TodoCompleto.Service.TransactionManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontControllerTransaction {


    @Autowired
    private TransactionManagerInterface gestorTransaction;




    //Llamar todas las transacciones
    @GetMapping("/welcomeTransactions")
    public String getWellcomeTransaction (Model model){
        model.addAttribute("transactions",gestorTransaction.getTransactions());
        return "welcome-transactions-new";
    }


    //Crear nueva transacción
    @GetMapping("/addtransaction")
    public String getAddTransaction (Model model){
        model.addAttribute("formTransaction", new Transaction());
        model.addAttribute("rolesList", Enum_RoleTransaction.values());
        return "add-transaction-new";
    }

    @PostMapping("/transaction/register")
    public String postAddTransaction (@ModelAttribute("formTransaction") Transaction transaction_parametro){
        try {
            String mensaje = gestorTransaction.setTransaction(transaction_parametro);
            return "redirect:/welcomeTransactions";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }



    //Actualizar transacción
    @GetMapping("/transaction/update/{id}")
    public String getUpdateTransaction (@PathVariable Long id, Model model){
        try {
            model.addAttribute("formUpdateTransaction",gestorTransaction.getTransaction(id));
            model.addAttribute("rolesList", Enum_RoleTransaction.values());
            return "update-transaction";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

    @PostMapping("/transaction/update/register")
    public String patchTransaction(@ModelAttribute("formUpdateTransaction") Transaction transactionParametro){
        try {
            gestorTransaction.UpdateTransaction(transactionParametro,transactionParametro.getId());
            return "redirect:/welcomeTransactions";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }



    //Borrar
    @RequestMapping(value = "/transaction/front/{id}", method = RequestMethod.GET)
    public String deleteTransaction (@PathVariable (name = "id") Long id) {
        try {
            gestorTransaction.DeleteTransaction(id);
            return "redirect:/welcomeTransactions";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }




    @GetMapping("/updatetransaction")
    public String getUpdateTransaction (Model model){
        model.addAttribute("formUpdateTransaction", new Transaction());
        model.addAttribute("rolesList", Enum_RoleTransaction.values());
        return "update-transaction";
    }


}
