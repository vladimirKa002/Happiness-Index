package com.innohackathon.happinessindex.controllers;

import com.innohackathon.happinessindex.models.DataPackage;
import com.innohackathon.happinessindex.models.IndexPackage;
import com.innohackathon.happinessindex.repositories.DataRepository;
import com.innohackathon.happinessindex.repositories.IndexesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ControllerMain {
    @Autowired
    DataRepository dataRepository;

    @Autowired
    IndexesRepository indexesRepository;

    @GetMapping({"/main", "/"})
    public String getPage() {
        return "main";
    }


    @GetMapping(value = "/main/getusers")
    public ResponseEntity<?> getusers(@RequestParam Optional<String> name,
                                       @RequestParam Optional<String> surname){
        List<DataPackage> dataPackages = null;
        if (!name.get().equals("") & !surname.get().equals(""))
            dataPackages = dataRepository.findAll(name.get(), surname.get());
        else if (!name.get().equals("")) {
            dataPackages = dataRepository.findAll_name(name.get());
        }
        else if (!surname.get().equals("")) {
            dataPackages = dataRepository.findAll_sur(surname.get());
        }
        else return ResponseEntity.ok(new String[0]);

        String[] found_users = new String[dataPackages.size()];
        for (int i = 0; i< found_users.length;i++) {
            DataPackage dp = dataPackages.get(i);
            found_users[i] = dp.getId()+": "+dp.getFirst_name()+" "+dp.getLast_name();
        }
        return ResponseEntity.ok(found_users);
    }

    @GetMapping(value = "/main/getuserinfo")
    public ResponseEntity<?> getUserInfo(@RequestParam Optional<Long> id){
        List<IndexPackage> indexPackages = indexesRepository.find(id.get());
        List<DataPackage> dataPackages = dataRepository.find(id.get());
        return ResponseEntity.ok(new Response_UserInfo(indexPackages.get(0), dataPackages.get(0)));
    }
}
