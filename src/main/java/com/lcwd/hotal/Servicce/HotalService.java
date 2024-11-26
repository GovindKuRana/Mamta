package com.lcwd.hotal.Servicce;

import com.lcwd.hotal.Entity.Hotal;
import com.lcwd.hotal.Repositroy.HotalRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotalService {
    @Autowired
    private HotalRepositroy repositroy;

    //add data databse
    public Hotal addHotal(Hotal hotal)
    {
        Hotal hotal1=repositroy.save(hotal);
        return hotal1;
    }
    // delet the data database through id
    public void deleteHotal(int id)
    {
        repositroy.deleteById(id);
    }
    //get all the data through the databse
    public List<Hotal> getAllHotal()
    {
        List<Hotal>hotal=repositroy.findAll();
        return hotal;
    }
    //update the id
    public Hotal updateHotal(int id,Hotal hotal)
    {
        Optional<Hotal>opReg =repositroy.findById(id);
        Hotal ho=opReg.get();
        ho.setId(hotal.getId());
        ho.setName(hotal.getName());
        ho.setLocation(hotal.getLocation());
        ho.setAbout(hotal.getAbout());
        repositroy.save(hotal);
        return hotal;

    }
}
