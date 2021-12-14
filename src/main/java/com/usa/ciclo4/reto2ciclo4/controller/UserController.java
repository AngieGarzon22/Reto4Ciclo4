package com.usa.ciclo4.reto2ciclo4.controller;

import com.usa.ciclo4.reto2ciclo4.model.User;
import com.usa.ciclo4.reto2ciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author angieg
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    /**
     * Clase userService
     */
    @Autowired
    private UserService userService;

    /**
     * Manejador Get para obtener todo
     * @return obteneer usuarios existentes
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Manejador Post para crear nuevo
     * @param user agregar nuevo usurio
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }

    /**
     * Manejador Update para actualizar nuevo usuario
     * @param user actualizar
     * @return datos nuevos
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    /**
     * Manejador delete para borrar usuarios
     * @param id borrar por id
     * @return usuario vacio
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }

    /**
     * Metodo autenticar correo y contraseña
     * @param email correo
     * @param password contraseña
     * @return correo existente
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email,password);
    }

    /**
     * Metodo verificar correo
     * @param email verificar correo
     * @return correo
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists (@PathVariable("email") String email){
        return userService.emailExists(email);
    }

    /**
     * Metodo obtener id
     * @param id usuario
     * @return id usuario
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
}