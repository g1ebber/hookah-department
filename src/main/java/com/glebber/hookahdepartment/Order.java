package com.glebber.hookahdepartment;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;
@Data
public class Order {
    private String name;
    private String table;
    private String number;
    private String date;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<HookahBuild> hookahBuildList = new ArrayList<>();
    public void addHookahBuild(HookahBuild hookahBuild) {
        this.hookahBuildList.add(hookahBuild);
    }
}
