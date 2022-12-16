package service.impl;

import model.Book;
import model.User;
import service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    List<User>userList=new ArrayList<>();
    @Override
    public String createUser(List<User> users) {
        Scanner sc=new Scanner(System.in);
        System.out.print(sc.nextLong()+"Write ID: ");
        System.out.print(sc.next().toUpperCase()+"Write name: ");
        System.out.print(sc.next().toUpperCase()+"Write surname: ");
        System.out.print(sc.next().toUpperCase()+"Write surname: ");
        System.out.print(sc.next()+"Write email: ");
        System.out.print(sc.next().toUpperCase()+"Write phone: ");
        System.out.print(sc.next().toUpperCase()+"Write gender: ");
        System.out.print(BigDecimal.valueOf(sc.nextInt())+"Write money: ");
        this.userList.addAll(users);
        return " create ";
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public String removeUserByName(String name) {
        return null;
    }

    @Override
    public void updateUser(Long id) {

    }

    @Override
    public void groupUsersByGender() {

    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        return null;
    }
}
