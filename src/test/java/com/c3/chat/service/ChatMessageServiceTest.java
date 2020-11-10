package com.c3.chat.service;//package com.c3.idiomas.service;
//
//import com.c3.idiomas.model.LanguageLevel;
//import com.c3.idiomas.repository.LanguageLevelRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//
//public class LanguageLevelServiceTest {
//
//    private List<LanguageLevel> levelList;
//
//    @InjectMocks
//    private LanguageLevelService service;
//
//    @Mock
//    private LanguageLevelRepository repository;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//
//        levelList = new ArrayList<>();
//        levelList.add(new LanguageLevel("Básico"));
//        levelList.add(new LanguageLevel("Intermediário"));
//        levelList.add(new LanguageLevel("Avançado"));
//    }
//
//    @Test
//    public void deveSalvarNivelComSucesso() {
//
//        LanguageLevel level = new LanguageLevel("Avançado");
//
//        when(this.repository.save(ArgumentMatchers.any(LanguageLevel.class))).thenReturn(level);
//
//        LanguageLevel l = this.service.saveLanguageLevel(level);
//
//        verify(this.repository, times(1)).save(level);
//
//        assertNotNull(l);
//
//    }
//
//    @Test
//    public void deveRetornarListaNiveis() {
//
//        when(this.repository.findAll()).thenReturn(levelList);
//
//        Iterable<LanguageLevel> level = this.service.getLanguageLevels();
//
//        verify(this.repository, times(1)).findAll();
//
//        assertNotNull(level);
//    }
//
//    @Test
//    public void deveRetornarNivelPorId(){
//
//        LanguageLevel language = levelList.get(0);
//
//        when(repository.findById(anyLong())).thenReturn(Optional.of(language));
//
//        Optional<LanguageLevel> retorno = this.service.getLanguageLevelById(anyLong());
//
//        verify(repository, times(1)).findById(anyLong());
//
//        assertNotNull(retorno);
//    }
//
//    @Test
//    public void deveAtualizarNivel() {
//
//        LanguageLevel level = new LanguageLevel("Avançado");
//
//        given(repository.findById(level.getId())).willReturn(Optional.of(level));
//        when(this.repository.save(any(LanguageLevel.class))).thenReturn(level);
//
//        this.service.saveLanguageLevel(level);
//
//        LanguageLevel atualizado = new LanguageLevel("Avançado 2");
//
////        when(repository.(any(LanguageLevel.class), anyLong())).thenReturn(atualizado);
//
//        LanguageLevel retorno = this.service.updateLanguageLevel(atualizado, 1L);
//
//        verify(this.service, times(1)).updateLanguageLevel(atualizado, 1L);
//
//        assertNotNull(retorno);
//
//    }
//
//    @Test
//    public void deveDeletarNivel() {
//
//        LanguageLevel level = new LanguageLevel("Avançado");
//
//        given(repository.findById(level.getId())).willReturn(Optional.of(level));
//        when(this.service.saveLanguageLevel(any(LanguageLevel.class))).thenReturn(level);
//
//        this.service.saveLanguageLevel(level);
//
//        when(service.deleteLanguageLevel(anyLong())).thenReturn(true);
//
//        boolean retorno = this.service.deleteLanguageLevel(anyLong());
//
//        verify(this.repository, times(1)).deleteById(anyLong());
//
//        assertNotNull(retorno);
//        assertTrue(retorno);
//    }
//}
