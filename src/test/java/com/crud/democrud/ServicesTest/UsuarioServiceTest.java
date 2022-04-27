package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;


import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioServiceTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void testGuardarUsuario(){
        UsuarioModel usuarioModel=new UsuarioModel("aquaman","aqua@gmail.com",99);
        UsuarioModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
        assertNotNull(usuarioModelRegistrado);
    }
    @Test
    public void testActualizarUsuario(){
        UsuarioModel usuarioModel=new UsuarioModel();
        usuarioModel.setId(new Long(1));
        usuarioModel.setNombre("Pepe");
       // usuarioModel.setEmail();
        //usuarioModel.setPrioridad();
        BindingResult result =
                new BeanPropertyBindingResult(usuarioModel, "usuarioModel");
        String cancelar = null;
        ModelMap model = new ModelMap();
        String accion = "ActualizarUsuario";
        Assert.assertEquals(false, model.containsAttribute("futuraAccion"));
    }



    @Test
    public void testBuscarUsuarioPorId(){
        Long idBuscado=1L;
        Optional<UsuarioModel> usuarioModelBuscado=usuarioRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarUsuarios(){
        List<UsuarioModel> usuarioModelList=(List<UsuarioModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }

    @Test
    public void testobtenerUsuarioPorPrioridad(){
        Long prioridad=1L;
        Optional<UsuarioModel> usuarioModelBuscado=usuarioRepository.findById(prioridad);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(prioridad);
    }


}
