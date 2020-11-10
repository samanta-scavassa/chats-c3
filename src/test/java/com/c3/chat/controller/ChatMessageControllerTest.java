package com.c3.chat.controller;//package com.c3.idiomas.controller;
//
//import com.c3.idiomas.model.LanguageLevel;
//import com.c3.idiomas.service.LanguageLevelService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//
//public class LanguageLevelControllerTest {
//
//    private List<LanguageLevel> levelList;
//
//    @Mock
//    private LanguageLevelService service;
//
//    @InjectMocks
//    private LanguageLevelController controller;
//
//    @Before
//    public void setUp() {
//
//        MockitoAnnotations.initMocks(this);
//
//        levelList = new ArrayList<>();
//        levelList.add(new LanguageLevel("Básico"));
//        levelList.add(new LanguageLevel("Intermediário"));
//        levelList.add(new LanguageLevel("Avançado"));
//
//    }
//
//    @Test
//    public void deveRetornarListaDeNiveis() {
//
//        given(this.service.getLanguageLevels()).willReturn(levelList);
//        ResponseEntity<Iterable<LanguageLevel>> levels = this.controller.getLanguages();
//        verify(this.service, times(1)).getLanguageLevels();
//
//        assertNotNull(levels);
//        assertNotNull(levels.getBody());
//        assertEquals(HttpStatus.OK, levels.getStatusCode());
//
//    }
//
//    @Test
//    public void deveRetornarNivelPorId() {
//
//        LanguageLevel level = levelList.get(0);
//
//        when(service.getLanguageLevelById(anyLong())).thenReturn(Optional.of(level));
//
//        ResponseEntity<LanguageLevel> retorno = this.controller.getLanguageLevelById(anyLong());
//
//        verify(service, times(1)).getLanguageLevelById(anyLong());
//
//        assertNotNull(retorno);
//        assertNotNull(retorno.getBody());
//        assertEquals(HttpStatus.OK, retorno.getStatusCode());
//    }
//
//    @Test
//    public void DeveRetornar404CasoNãoEncontreNivel() {
//
//        given(this.service.getLanguageLevels()).willReturn(levelList);
//
//        Long languageId = (long) (levelList.size() + 1);
//
//        ResponseEntity<LanguageLevel> retorno = this.controller.getLanguageLevelById(languageId);
//
//        verify(service, times(1)).getLanguageLevelById(languageId);
//
//        assertNotNull(retorno);
//        assertNull(retorno.getBody());
//        assertEquals(HttpStatus.NOT_FOUND, retorno.getStatusCode());
//    }
//
//    @Test
//    public void deveCadastrarNivel() {
//
//        LanguageLevel level = levelList.get(0);
//        level.setId(1L);
//
//        when(service.saveLanguageLevel(any(LanguageLevel.class))).thenReturn(level);
//
//        ResponseEntity retorno = this.controller.postLanguageLevel(level);
//
//        verify(this.service, times(1)).saveLanguageLevel(level);
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
//
//    }
//
//    @Test
//    public void DeveRetornar400AoCadastrarNivelComNomeNUll() {
//        LanguageLevel level = new LanguageLevel(null);
//        level.setId(1L);
//
//        ResponseEntity retorno = this.controller.postLanguageLevel(level);
//
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.BAD_REQUEST, retorno.getStatusCode());
//    }
//
//    @Test
//    public void DeveRetornar400AoCadastrarNivelVazio() {
//        LanguageLevel level = new LanguageLevel("");
//        level.setId(1L);
//
//        ResponseEntity retorno = this.controller.postLanguageLevel(level);
//
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.BAD_REQUEST, retorno.getStatusCode());
//    }
//
//    @Test
//    public void deveAtualizarNivel() {
//
//        LanguageLevel level = new LanguageLevel("Avançado");
//
//        given(service.getLanguageLevelById(level.getId())).willReturn(Optional.of(level));
//        when(this.service.saveLanguageLevel(any(LanguageLevel.class))).thenReturn(level);
//
//        this.service.saveLanguageLevel(level);
//
//        LanguageLevel atualizado = new LanguageLevel("Avançado 2");
//
//        when(service.updateLanguageLevel(any(LanguageLevel.class), anyLong())).thenReturn(atualizado);
//
//        ResponseEntity retorno = this.controller.putLanguageLevel(1L, atualizado);
//
//        verify(this.service, times(1)).updateLanguageLevel(atualizado, 1L);
//
//        assertNotNull(retorno);
//        assertNotNull(retorno.getBody());
//        assertEquals(HttpStatus.OK, retorno.getStatusCode());
//        assertEquals(atualizado, retorno.getBody());
//
//    }
//
//    @Test
//    public void deveRetornar404AoTentarAtualizarNivelInexistente() {
//
//        LanguageLevel atualizado = new LanguageLevel("Mega Avançado");
//
//        ResponseEntity retorno = this.controller.putLanguageLevel(1L, atualizado);
//
//        assertNotNull(retorno);
//        assertNull(retorno.getBody());
//        assertEquals(HttpStatus.NOT_FOUND, retorno.getStatusCode());
//
//    }
//
//    @Test
//    public void deveDeletarNivel() {
//        LanguageLevel level = new LanguageLevel("Avançado");
//
//        given(service.getLanguageLevelById(level.getId())).willReturn(Optional.of(level));
//        when(this.service.saveLanguageLevel(any(LanguageLevel.class))).thenReturn(level);
//
//        this.service.saveLanguageLevel(level);
//
//        when(service.deleteLanguageLevel(anyLong())).thenReturn(true);
//
//        ResponseEntity retorno = this.controller.deleteLanguageLevel(anyLong());
//
//        verify(this.service, times(1)).deleteLanguageLevel(anyLong());
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.OK, retorno.getStatusCode());
//    }
//
//    @Test
//    public void deveRetornar404AoTentarDeletarNivelInexistente(){
//        when(service.deleteLanguageLevel(anyLong())).thenReturn(false);
//
//        ResponseEntity retorno = this.controller.deleteLanguageLevel(anyLong());
//
//        verify(this.service, times(1)).deleteLanguageLevel(anyLong());
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.NOT_FOUND, retorno.getStatusCode());
//
//    }
//}
