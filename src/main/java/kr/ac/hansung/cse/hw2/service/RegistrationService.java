package kr.ac.hansung.cse.hw2.service;

import kr.ac.hansung.cse.hw2.entity.MyRole;
import kr.ac.hansung.cse.hw2.entity.MyUser;

import java.util.List;

public interface RegistrationService {
    MyUser createUser(MyUser user, List<MyRole> userRoles);

    boolean checkEmailExists(String email);

    MyRole findByRolename(String rolename);
}
