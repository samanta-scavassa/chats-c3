package com.c3.chat.controller;//package com.c3.idiomas.controller;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//
//public class LanguageControllerTest {
//
//    private List<Language> languageList;
//
//    @Mock
//    private LanguageService service;
//
//    @InjectMocks
//    private LanguageController controller;
//
//    @Before
//    public void setUp() {
//
//        MockitoAnnotations.initMocks(this);
//
//        languageList = new ArrayList<>();
//        languageList.add(new Language("Maria", "Silva", "123",  "msilva@email.com",
//                LocalDate.now(), true, "Brasil"));
//        languageList.add(new Language("Egon", "Hoffmann", "123",  "egon@email.com",
//                LocalDate.now(), true, "Alemanha"));
//        languageList.add(new Language("Laura", "Ricci", "123",  "lricci@email.com",
//                LocalDate.now(), true, "Itália"));
//
//    }
//
//    @Test
//    public void deveRetornarListaDeUsuarios() {
//
//        given(this.service.getLanguages()).willReturn(languageList);
//        ResponseEntity<Iterable<Language>> Languages = this.controller.getLanguages();
//        verify(this.service, times(1)).getLanguages();
//
//        assertNotNull(Languages);
//        assertNotNull(Languages.getBody());
//        assertEquals(HttpStatus.OK, Languages.getStatusCode());
//
//    }
//
//    @Test
//    public void deveRetornarUsuarioPorId() {
//
//        Language language = languageList.get(0);
//
//        when(service.getLanguageById(anyLong())).thenReturn(Optional.of(language));
//
//        ResponseEntity<Language> retorno = this.controller.getLanguageById(anyLong());
//
//        verify(service, times(1)).getLanguageById(anyLong());
//
//        assertNotNull(retorno);
//        assertNotNull(retorno.getBody());
//        assertEquals(HttpStatus.OK, retorno.getStatusCode());
//    }
//
//    @Test
//    public void DeveRetornar404CasoNãoEncontreUsuario() {
//
//        given(this.service.getLanguages()).willReturn(languageList);
//
//        Long languageId = (long) (languageList.size() + 1);
//
//        ResponseEntity<Language> retorno = this.controller.getLanguageById(languageId);
//
//        verify(service, times(1)).getLanguageById(languageId);
//
//        assertNotNull(retorno);
//        assertNull(retorno.getBody());
//        assertEquals(HttpStatus.NOT_FOUND, retorno.getStatusCode());
//    }
//
//    @Test
//    public void deveCadastrarUsuario() {
//
//        Language language = languageList.get(0);
//        Language.setId(1L);
//
//        when(service.saveLanguage(any(Language.class))).thenReturn(language);
//
//        ResponseEntity retorno = this.controller.postLanguage(language);
//
//        verify(this.service, times(1)).saveLanguage(language);
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
//
//    }
//
//    @Test
//    public void DeveRetornar400AoCadastrarUsuarioComEmailNUll() {
//        Language language = new Language("Maria", "Silva", "123",  null,
//                LocalDate.now(), true, "Brasil");
//        language.setId(1L);
//
//        ResponseEntity retorno = this.controller.postLanguage(language);
//
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.BAD_REQUEST, retorno.getStatusCode());
//    }
//
//    @Test
//    public void DeveRetornar400AoCadastrarUsuarioSemEmail() {
//        Language language = new Language("Maria", "Silva", "123",  "",
//                LocalDate.now(), true, "Brasil");
//        language.setId(1L);
//
//        ResponseEntity retorno = this.controller.postLanguage(language);
//
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.BAD_REQUEST, retorno.getStatusCode());
//    }
//
//    @Test
//    public void deveAtualizarDadosDeUsuario() {
//
//        Language language = new Language(1L, "Maria", "Silva", "123",  "msilva@email.com",
//                LocalDate.now(), true, "Brasil");
//
//        given(service.getLanguageById(language.getId())).willReturn(Optional.of(language));
//        when(this.service.saveLanguage(any(Language.class))).thenReturn(language);
//
//        this.service.saveLanguage(language);
//
//        Language atualizado = new Language(1L, "Maria", "Silva Santos", "123",  "msilva@email.com",
//                LocalDate.now(), true, "Brasil");
//
//        when(service.updateLanguage(any(Language.class), anyLong())).thenReturn(atualizado);
//
//        ResponseEntity retorno = this.controller.putLanguage(1L, atualizado);
//
//        verify(this.service, times(1)).updateLanguage(atualizado, 1L);
//
//        assertNotNull(retorno);
//        assertNotNull(retorno.getBody());
//        assertEquals(HttpStatus.OK, retorno.getStatusCode());
//        assertEquals(atualizado, retorno.getBody());
//
//    }
//
//    @Test
//    public void deveRetornar404AoTentarAtualizarUsuarioInexistente() {
//
//        Language atualizado = new Language(1L, "Maria", "Silva Santos", "123",  "msilva@email.com",
//                LocalDate.now(), true, "Brasil");
//
//        ResponseEntity retorno = this.controller.putLanguage(1L, atualizado);
//
//        assertNotNull(retorno);
//        assertNull(retorno.getBody());
//        assertEquals(HttpStatus.NOT_FOUND, retorno.getStatusCode());
//
//    }
//
//    @Test
//    public void deveDeletarUsuario() throws Exception {
//        Language language = new Language(1L, "Maria", "Silva", "123",  "msilva@email.com",
//                LocalDate.now(), true, "Brasil");
//
//        given(service.getLanguageById(language.getId())).willReturn(Optional.of(language));
//        when(this.service.saveLanguage(any(Language.class))).thenReturn(language);
//
//        this.service.saveLanguage(language);
//
//        when(service.deleteLanguage(anyLong())).thenReturn(true);
//
//        ResponseEntity retorno = this.controller.deleteLanguage(anyLong());
//
//        verify(this.service, times(1)).deleteLanguage(anyLong());
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.OK, retorno.getStatusCode());
//    }
//
//    @Test
//    public void deveRetornar404AoTentarDeletarUsuarioInexistente(){
//        when(service.deleteLanguage(anyLong())).thenReturn(false);
//
//        ResponseEntity retorno = this.controller.deleteLanguage(anyLong());
//
//        verify(this.service, times(1)).deleteLanguage(anyLong());
//
//        assertNotNull(retorno);
//        assertEquals(HttpStatus.NOT_FOUND, retorno.getStatusCode());
//
//    }
//}
