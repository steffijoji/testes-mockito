package me.dio.mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("BA", "Salvador", "Vila Um",
                "Rua Dois", "apto 3");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("10200100")).thenReturn(dadosLocalizacao);
        Pessoa pessoa1 = cadastrarPessoa.cadatrarPessoa("Maria", "123456", LocalDate.now(), "10200100");
    }
}
