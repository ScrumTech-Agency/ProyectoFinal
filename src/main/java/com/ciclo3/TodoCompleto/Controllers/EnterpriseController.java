package com.ciclo3.TodoCompleto.Controllers;


import com.ciclo3.TodoCompleto.Models.Enterprise;
import com.ciclo3.TodoCompleto.Models.Transaction;
import com.ciclo3.TodoCompleto.Service.EnterpriseManagerInterface;
import com.ciclo3.TodoCompleto.Service.TransactionManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class EnterpriseController {
    @Autowired
    private EnterpriseManagerInterface EnterpriseBDX;
    @Autowired
    private TransactionManagerInterface transactionX;

    //Metodos para crear un Enterprise

    @GetMapping("/EnterpriseRegisterNew")
    public String getEnterpriseRegister(Model model){
        model.addAttribute("formEnterpriseRegister",new Enterprise());
        return "add-enterprise";
    }

    @PostMapping("/CreateEnterpriseNew")
    public String CreateEnterprise (@ModelAttribute("redirect:/WelcomeEnterprise") Enterprise EnterpriseX) throws Exception {
        String AnswerCreateEnterprise = EnterpriseBDX.setCreateEnterprise(EnterpriseX);
        return AnswerCreateEnterprise;
    }


    //Metodo para listar Enterprise

    @GetMapping("/welcomeEnterpriseNew")
    public String getUserList(Model model){

        int i = 0;
        int j = 0;
        float total = 0;
        float cantidad = 0;
        List<Float> transactionsOfEnterprise = new ArrayList<>();
        List<Transaction> transactionsBD = transactionX.getTransactions();
        List<Enterprise> enterprisesBD = EnterpriseBDX.getEnterpriseX();
        for (i=0; i<enterprisesBD.size(); i++){
            for (j=0; j<transactionsBD.size(); j++){
                if (transactionsBD.get(j).getEnterprise().getIdEnterprise()==enterprisesBD.get(i).getIdEnterprise()){
                    cantidad =transactionsBD.get(j).getAmount();
                    String xxx = String.valueOf(transactionsBD.get(j).getRoleTransaction());
                    if(xxx.equals("[Ingreso]")){
                        total = total + cantidad;
                    }else {
                      total = total - cantidad;
                    }
                }
            }
            transactionsOfEnterprise.add(total);
            enterprisesBD.get(i).setTotal(total);
            try {
                EnterpriseBDX.UpdateEnterpriseAll(enterprisesBD.get(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            total=0;

       }

        model.addAttribute("Enterprise",EnterpriseBDX.getEnterpriseX());
        List<Enterprise> ExEnterprise = EnterpriseBDX.getEnterpriseX();
        return "WelcomeEnterpriseNew";
    }


    //Metodo para borrar un Enterprise
    @PostMapping("/deleteEnterpriseNew/{idEnterprise}")
    public String deleteEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            EnterpriseBDX.DeleteEnterprise(idEnterprise);
            return "redirect:/welcomeEnterpriseNew";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Metodo para actualizar un Enterprise

    @GetMapping("/updateEnterpriseNew/{idEnterprise}")
    public String updateEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            model.addAttribute("EnterpriseUpdate",EnterpriseBDX.getOnlyEnterprise(idEnterprise));

            return "update-enterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/updateEnterpriseNew")
    public String updateEnterprise (@ModelAttribute("redirect:/welcomeEnterpriseNew") Enterprise EnterpriseX){
        try {
            EnterpriseBDX.UpdateEnterpriseAll(EnterpriseX);
            return "redirect:/welcomeEnterpriseNew";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

    //Metodo para presentar empleados de la empresa
    @GetMapping("/EmployeeOfEnterpriseBD/{idEnterprise}")
    public String EmployeeOfEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            Enterprise EnterpriseX = EnterpriseBDX.getOnlyEnterprise(idEnterprise);
            model.addAttribute("EmployeesEnterprise",EnterpriseX.getEmployees());
            return "EmployeesOfEnterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

}
