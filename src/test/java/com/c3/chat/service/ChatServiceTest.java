package com.c3.chat.service;//package com.c3.idiomas.service;
//
//import org.junit.Before;
//import org.junit.Test;
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
//import static org.mockito.Mockito.*;
//
//
//public class LanguageServiceTest {
//
//    private List<Language> languageList;
//
//    @InjectMocks
//    private LanguageService service;
//
//    @Mock
//    private LanguageRepository repository;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//
//        languageList = new ArrayList<>();
//        languageList.add(new Language("Maria", "Silva", "123",  "msilva@email.com",
//                LocalDate.now(), true, "Brasil"));
//        languageList.add(new Language("Egon", "Hoffmann", "123",  "egon@email.com",
//                LocalDate.now(), true, "Alemanha"));
//        languageList.add(new Language("Laura", "Ricci", "123",  "lricci@email.com",
//                LocalDate.now(), true, "Itália"));
//    }
//
////    @Test
////    public void deveSalvarUsuarioComSucesso() {
////
////        Language language = new Language(1L,"Maria", "Silva", "123",  "msilva@email.com",
////                LocalDate.now(), true, "Brasil");
////
////        when(this.repository.save(ArgumentMatchers.any(Language.class))).thenReturn(language);
////
////        Language l = this.service.saveLanguage(language);
////
////        verify(this.repository, times(1)).save(language);
////
////        assertNotNull(l);
////
////    }
//
//    @Test
//    public void deveRetornarListaDeUsuarios() {
//
//        when(this.repository.findAll()).thenReturn(languageList);
//
//        Iterable<Language> linguas = language.getLanguages();
//
//        verify(this.repository, times(1)).findAll();
//
//        assertNotNull(linguas);
//    }
//
//    @Test
//    public void deveRetornarUsuarioPorId(){
//
//        Language language = languageList.get(0);
//
//        when(repository.findById(anyLong())).thenReturn(Optional.of(language));
//
//        Optional<Language> retorno = this.service.getLanguageById(anyLong());
//
//        verify(repository, times(1)).findById(anyLong());
//
//        assertNotNull(retorno);
//    }
//
////    @Test
////    public void deveAtualizarUsuario() {
////
////        Language language = new Language(1L, "Maria", "Silva", "123",  "msilva@email.com",
////                LocalDate.now(), true, "Brasil");
////
////        given(repository.findById(Language.getId())).willReturn(Optional.of(language));
////        when(this.repository.save(any(Language.class))).thenReturn(language);
////
////        this.service.saveLanguage(language);
////
////        Language atualizado = new Language(1L, "Maria", "Silva Santos", "123",  "msilva@email.com",
////                LocalDate.now(), true, "Brasil");
////
//////        when(repository.(any(Language.class), anyLong())).thenReturn(atualizado);
////
////        Language retorno = this.service.updateLanguage(atualizado, 1L);
////
////        verify(this.service, times(1)).updateLanguage(atualizado, 1L);
////
////        assertNotNull(retorno);
////
////    }
//
////    @Test
////    public void deveDeletarUsuario() {
////
////        Language language = new Language(1L, "Maria", "Silva", "123",  "msilva@email.com",
////                LocalDate.now(), true, "Brasil");
////
////        given(repository.findById(Language.getId())).willReturn(Optional.of(language));
////        when(this.service.saveLanguage(any(Language.class))).thenReturn(language);
////
////        this.service.saveLanguage(language);
////
////        when(service.deleteLanguage(anyLong())).thenReturn(true);
////
////        boolean retorno = this.service.deleteLanguage(anyLong());
////
////        verify(this.repository, times(1)).deleteById(anyLong());
////
////        assertNotNull(retorno);
////        assertTrue(retorno);
////    }
//}
