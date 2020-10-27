package com.ipartek.formacion.spring.ejemplospringsecurity;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/principal")
public class UserController {
	@GetMapping
	@RolesAllowed("ROLE_ADMIN")
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }
}
