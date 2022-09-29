package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Employee;
import com.ciclo3.TodoCompleto.Models.Enum_RoleName;
import com.ciclo3.TodoCompleto.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeManagerl implements EmployeeManagerInterface {

    @Autowired
    private EmployeeRepository repository;
    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployee(Long idEmployee) throws Exception {
        Optional<Employee> employeeBd = repository.findById(idEmployee);

        if (employeeBd.isPresent()) {
            return employeeBd.get();
        }
        throw  new Exception("Usuario no existe");
    }

    @Override
    public String setEmployee(Employee Employees) throws Exception {

        repository.save(Employees);
        return "Usuario Creado Exitosamente";
    }

    @Override
    public Employee UpdateEmployeeAll(Employee EmployeeUpdate, Long id) throws Exception {
        return null;
    }

    @Override
    public Employee UpdateEmployee(Employee employeeUpdate, Long id) throws Exception {
        Employee employee_Bd = getEmployee(id);

        if (employeeUpdate.getNameEmpl() != null && !employeeUpdate.getNameEmpl().equals("")) {
            employee_Bd.setNameEmpl(employeeUpdate.getNameEmpl());
        }

        if (employeeUpdate.getEmailEmpl() != null && !employeeUpdate.getEmailEmpl().equals("")) {
            employee_Bd.setEmailEmpl(employeeUpdate.getEmailEmpl());
        }

        List <String> roles = new ArrayList<>();
        if(employeeUpdate.getRoleEmpl()!=null){
            for (Enum_RoleName rol : employeeUpdate.getRoleEmpl()){
                roles.add(new String(rol.name()));
            }
        }
        for (String rolValid: roles){
            if (!rolValid.equals("")){
                employee_Bd.setRoleEmpl(employeeUpdate.getRoleEmpl());
            }
        }
        return repository.save(employee_Bd);
    }

    @Override
    public String DeleteEmployee(Long idEmployee) throws Exception {
        repository.deleteById(idEmployee);
        return "Usuario Eliminado Exitosamente";
    }
}
