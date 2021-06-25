package br.edu.usj.ads.pw.agendabackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@ResponseBody
@CrossOrigin
public class ContatoController {
    
    @Autowired
    ContatoRepository contatoRepository;

    @GetMapping(value="/")
    public List<Contato> getListarTodos() {
        List<Contato> lista = contatoRepository.findAll();
        return lista;
    }
    
    @GetMapping(value="/detalhes/{id}")
    public Contato getDetalhes(@PathVariable Long id) {
        Contato contato = new Contato();
        contato = contatoRepository.findById(id).get();
        return contato;
    }

    @PostMapping(value="/adicionar")
    public Contato postAdicionar(@RequestBody Contato contato) {
        Contato contatoNovo = contatoRepository.save(contato);
        return contatoNovo;
    }
    
    @GetMapping(value="/deletar/{id}")
    public void getDeletar(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }
    
}
