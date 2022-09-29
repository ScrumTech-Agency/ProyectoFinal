package com.ciclo3.TodoCompleto.Service;


import com.ciclo3.TodoCompleto.Models.Enterprise;

import java.util.List;

public interface EnterpriseManagerInterface {
    public List<Enterprise> getEnterpriseX();
    public Enterprise getOnlyEnterprise(Long idEnterprise) throws Exception;
    public String setCreateEnterprise(Enterprise EnterpriseX) throws Exception;
    public Enterprise UpdateEnterpriseAll(Enterprise EnterpriseX) throws Exception;
    public String DeleteEnterprise(Long  idEnterprise) throws Exception;
}
