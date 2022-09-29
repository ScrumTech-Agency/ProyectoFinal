package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Enterprise;
import com.ciclo3.TodoCompleto.Repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseManager implements EnterpriseManagerInterface{
    //Atribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad enterprise
    @Autowired
    EnterpriseRepository repositoryEnterprise;


    //Metodo que me permite traer la lista de empresas
    public List<Enterprise> getEnterpriseX(){


        return repositoryEnterprise.findAll();
    }


    //Metodo que devuelve un solo Enterprise pasandole el idEnterprise como parametro
    public Enterprise getOnlyEnterprise(Long idEnterprise) throws Exception {
        Optional<Enterprise> EnterpriseBD = repositoryEnterprise.findById(idEnterprise);
        if(EnterpriseBD.isPresent()){
            return EnterpriseBD.get();
        }
        throw new Exception("IdEnterprise no asignado a ninguna enterprise de nuestra base de datos");
    }


    //Metodo que me permite adicionar un nuevo Enterprise al ArrayList
    public String setCreateEnterprise(Enterprise EnterpriseX) throws Exception {
        //Preguntamos si ya hay alguna enterprise ya registrada con ese Id.
        Optional<Enterprise> EnterpriseBD = repositoryEnterprise.findById(EnterpriseX.getIdEnterprise());
        if(!EnterpriseBD.isPresent()){
            repositoryEnterprise.save(EnterpriseX);
            return "CreateEnterpriseWhithSucces";

        }
        return ("Ese Id ya esta regitrado a una Enterprise Existente");
    }

    //Metodo para actualizar un Enterprise
    public Enterprise UpdateEnterpriseAll(Enterprise EnterpriseX) throws Exception {
        //LLamamos a la enterprise a actualizar de la BD
        Enterprise enterpriseBD = getOnlyEnterprise(EnterpriseX.getIdEnterprise());

        //Actualizamos atributos
        if(EnterpriseX.getName()!=null && !EnterpriseX.getName().equals("")){
            enterpriseBD.setName(EnterpriseX.getName());
        }

        if(EnterpriseX.getDocument()!=null && !EnterpriseX.getDocument().equals("")){
            enterpriseBD.setDocument(EnterpriseX.getDocument());
        }

        if(EnterpriseX.getAddress()!=null && !EnterpriseX.getAddress().equals("")){
            enterpriseBD.setAddress(EnterpriseX.getAddress());
        }

        if(EnterpriseX.getPhone()!=null && !EnterpriseX.getPhone().equals("")){
            enterpriseBD.setPhone(EnterpriseX.getPhone());
        }

        if(EnterpriseX.getCreatedAt()!=null && !EnterpriseX.getCreatedAt().equals("")){
            enterpriseBD.setCreatedAt(EnterpriseX.getCreatedAt());
        }

        enterpriseBD.setUpdateAt(Today);

        return repositoryEnterprise.save(enterpriseBD);


    }

    //Metodo para eliminar un Enterprise
    public String DeleteEnterprise (Long idEnterprise) throws Exception {
        Optional<Enterprise> enterpriseBD = repositoryEnterprise.findById(idEnterprise);
        if(enterpriseBD.isPresent()){
            repositoryEnterprise.deleteById(idEnterprise);
            return "Enterprise Eliminada con exito";
        }
        throw new Exception("Enterprise NOOOOO encontarda");
    }

}
