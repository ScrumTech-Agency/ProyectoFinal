package com.ciclo3.TodoCompleto.Controllers;

import com.ciclo3.TodoCompleto.Models.Employee;
import com.ciclo3.TodoCompleto.Models.Enterprise;
import com.ciclo3.TodoCompleto.Models.Enum_RoleName;
import com.ciclo3.TodoCompleto.Models.Transaction;
import com.ciclo3.TodoCompleto.Service.EmployeeManagerInterface;
import com.ciclo3.TodoCompleto.Service.TransactionManagerInterface;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontControllerEmployee {
    @Autowired
    private EmployeeManagerInterface employeeManager;

    @Autowired
    private TransactionManagerInterface transactionX;


    //Método para llamar lista de empleados
    @GetMapping("/welcomeEmployee")
    public String getWelcome(Model model) {

        model.addAttribute("rol", Enum_RoleName.ROLE_ADMIN);
        model.addAttribute("employees", employeeManager.getEmployees());

        return "welcome-employee-new";
    }
    //Hasta aquí método de lista de empleados


    //Métodos para registrar empleado
    @GetMapping("/addemployee")
    public String getAddEmployee(Model model){

        model.addAttribute("employeeRegister", new Employee());
        model.addAttribute("rolesList",Enum_RoleName.values());
        return "add-employee-new";
    }

    @PostMapping("/employee/register")
    public String postEmployee(@ModelAttribute("employeeRegister")  Employee employeeParametro) {
        try {

            String mensaje = employeeManager.setEmployee(employeeParametro);

            return "redirect:/welcomeEmployee";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
    //Hasta aqui los metodos para registrar empleados


    // Métodos Para actualizar Empleador
    @GetMapping("/employee/update/{id}")
    public String getUsuario(@PathVariable Long id, Model model){
        try {
            model.addAttribute("userUpdate",employeeManager.getEmployee(id));
            model.addAttribute("rolesList", Enum_RoleName.values());
            return "update-employee";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }
    @PutMapping("/employee/front/update")
    public String putUsuario(@ModelAttribute("userUpdate") Employee employeeParametro) {
        try {
            employeeManager.UpdateEmployee(employeeParametro, employeeParametro.getIdEmpl());
            return "redirect:/welcomeEmployee";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }



    //Metodo para mostrar tranasacciones de un empleado
    @GetMapping("/transacciones/{idEmpleado}")
    public String EmployeeOfEnterprise(@PathVariable Long idEmpleado, Model model){

        try {

            int i = 0;
            List<Transaction> transactionsOfEmployee = new ArrayList<>();
            List<Transaction> transactionsBD = transactionX.getTransactions();
            for (i=0; i<transactionsBD.size(); i++){
                if (transactionsBD.get(i).getEmpleado().getIdEmpl()==idEmpleado){
                    System.out.println(transactionsBD.get(i).getRoleTransaction());
                    transactionsOfEmployee.add(transactionsBD.get(i));


                }
            }
            model.addAttribute("TrxEmployee",transactionsOfEmployee);
            return "transactionOfEmployee";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }



    //Métodos para Borrar empleados

    @DeleteMapping("/employee/front/{id}")
    public String deleteUser(@PathVariable Long id, Model model){
        try {
            employeeManager.DeleteEmployee(id);
            return "redirect:/welcomeEmployee";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }




    @GetMapping("/updateUser")
    public String getUpdateUser(Model model){

        return "update-employee";
    }

}
