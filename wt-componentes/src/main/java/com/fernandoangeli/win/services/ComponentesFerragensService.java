package com.fernandoangeli.win.services;

import com.fernandoangeli.win.domains.Ferragem;
import com.fernandoangeli.win.dtos.FerragemDto;
import com.fernandoangeli.win.repositories.FerragensRepository;
import com.fernandoangeli.win.services.exceptions.DatabaseException;
import com.fernandoangeli.win.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.fernandoangeli.win.services.components.util.CodeGenerator.CodeGenerator;

@Service
public class ComponentesFerragensService {
    @Autowired
    private FerragensRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public FerragemDto insert(FerragemDto ferragemDto) {
        Ferragem ferragem = convertDtoToDomain(ferragemDto);
        ferragem.setEstoque(0.0);
        ferragem.setReservaDeEstoque(0.0);
        ferragem = repository.save(ferragem);
        ferragem.setCodigo(CodeGenerator(ferragem.getTipoComponente().getId(), ferragem.getId()));
        ferragem = repository.save(ferragem);
        return convertDomainToDto(Optional.of(ferragem));
    }

    @Transactional(readOnly = true)
    public Optional<FerragemDto> findById(Long id) {
        verifyExistsId(id);
        Optional<Ferragem> ferragem = repository.findById(id);
        return Optional.of(convertDomainToDto(ferragem));
    }

    @Transactional(readOnly = true)
    public Page<FerragemDto> findAll(Pageable pageable){
        Page<Ferragem> ferragems = repository.findAll(pageable);
        return ferragems.map(x -> convertDomainToDto(x));
    }

    @Transactional
    public FerragemDto update(Long id, FerragemDto ferragemDto) {
        verifyExistsId(id);
        Ferragem ferragem = repository.getReferenceById(id);
        convertDtoToDomainUpdate(ferragem, ferragemDto);
        repository.save(ferragem);
        return convertDomainToDto(ferragem);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        verifyExistsId(id);
        try{
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Este item não pode ser deletado por causar quebra de integridade do banco de dados.");
        }
    }

    private FerragemDto convertDomainToDto(Optional<Ferragem> ferragem) {
        return mapper.map(ferragem, FerragemDto.class);
    }

    private FerragemDto convertDomainToDto(Ferragem ferragem) {
        return mapper.map(ferragem, FerragemDto.class);
    }

    private Ferragem convertDtoToDomain(FerragemDto ferragemDto) {
        return mapper.map(ferragemDto, Ferragem.class);
    }

    private void convertDtoToDomainUpdate(Ferragem ferragem, FerragemDto ferragemDto) {
        if(!ferragemDto.getFornecedoresId().isEmpty()) ferragem.getFornecedoresId().clear();
        mapper.map(ferragemDto, ferragem);
    }

    private void verifyExistsId(Long id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("O ID " + id + " nâo foi encontrado.");
    }

}
