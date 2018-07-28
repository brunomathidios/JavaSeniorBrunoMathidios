package br.com.mathidios.project;

import java.nio.charset.Charset;

import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;

import br.com.mathidios.project.model.entity.Colaborador;
import br.com.mathidios.project.model.entity.Setor;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaSeniorBrunoMathidiosApplication.class)
@AutoConfigureMockMvc
public class ColaboradorControllerTest {
	

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), 
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testeRecuperarColaboradorExistente() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/colaboradores/id/" + 1))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.nmColab", Is.is("Colab A")));
	}
	
	@Test
	public void testeRecuperarColaboradorNaoExistente() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/colaboradores/id/" + 189))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void testeRemoverColaboradorExistente() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/colaboradores/delete/" + 2))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testeRemoverColaboradorNaoExistente() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/colaboradores/delete/" + 189))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void testeRecuperarColaboradoresAgrupadosPorSetor() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/colaboradores"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(3)));
	}
	
	@Test
	public void testeCriarColaboradorValido() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/colaboradores/new")
			.content(new Gson().toJson(this.getColaboradorValido()))
			.contentType(this.contentType))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	private Colaborador getColaboradorValido() {
		Colaborador colab = new Colaborador();
		colab.setNmColab("Colab valido");
		colab.setCpfColab("45678912344");
		colab.setEmailColab("colabvalido@enterprise.com");
		colab.setTelColab("21999999991");
		Setor setor = new Setor();
		setor.setIdSetor(new Long(1));
		colab.setSetor(setor);
		return colab;
	}
	
	@Test
	public void testeCriarColaboradorNomeNull() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/colaboradores/new")
			.content(new Gson().toJson(this.getColaboradorNomeNull()))
			.contentType(this.contentType))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	private Colaborador getColaboradorNomeNull() {
		Colaborador colab = new Colaborador();
		colab.setCpfColab("45678912344");
		colab.setEmailColab("colabvalido@enterprise.com");
		colab.setTelColab("21999999991");
		Setor setor = new Setor();
		setor.setIdSetor(new Long(1));
		colab.setSetor(setor);
		return colab;
	}
	
	@Test
	public void testeCriarColaboradorCPFNull() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/colaboradores/new")
			.content(new Gson().toJson(this.getColaboradorCPFNull()))
			.contentType(this.contentType))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	private Colaborador getColaboradorCPFNull() {
		Colaborador colab = new Colaborador();
		colab.setNmColab("Colab cpf null");
		colab.setEmailColab("colabvalido@enterprise.com");
		colab.setTelColab("21999999991");
		Setor setor = new Setor();
		setor.setIdSetor(new Long(1));
		colab.setSetor(setor);
		return colab;
	}
	
	@Test
	public void testeCriarColaboradorEmailNull() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/colaboradores/new")
			.content(new Gson().toJson(this.getColaboradorEmailNull()))
			.contentType(this.contentType))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	private Colaborador getColaboradorEmailNull() {
		Colaborador colab = new Colaborador();
		colab.setNmColab("Colab email null");
		colab.setCpfColab("45678912349");
		colab.setTelColab("21999999991");
		Setor setor = new Setor();
		setor.setIdSetor(new Long(1));
		colab.setSetor(setor);
		return colab;
	}
	
	@Test
	public void testeCriarColaboradorEmailInvalido() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/colaboradores/new")
			.content(new Gson().toJson(this.getColaboradorEmailInvalido()))
			.contentType(this.contentType))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	private Colaborador getColaboradorEmailInvalido() {
		Colaborador colab = new Colaborador();
		colab.setNmColab("Colab email invalido");
		colab.setCpfColab("45678912349");
		colab.setEmailColab("colabinvalidoenterprise.com");
		colab.setTelColab("21999999991");
		Setor setor = new Setor();
		setor.setIdSetor(new Long(1));
		colab.setSetor(setor);
		return colab;
	}
	
	@Test
	public void testeCriarColaboradorTelefoneNull() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/colaboradores/new")
			.content(new Gson().toJson(this.getColaboradorTelefoneNull()))
			.contentType(this.contentType))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	private Colaborador getColaboradorTelefoneNull() {
		Colaborador colab = new Colaborador();
		colab.setNmColab("Colab telefone null");
		colab.setCpfColab("45678912349");
		Setor setor = new Setor();
		setor.setIdSetor(new Long(1));
		colab.setSetor(setor);
		return colab;
	}
	
	@Test
	public void testeCriarColaboradorSetorNull() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/colaboradores/new")
			.content(new Gson().toJson(this.getColaboradorSetorNull()))
			.contentType(this.contentType))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	private Colaborador getColaboradorSetorNull() {
		Colaborador colab = new Colaborador();
		colab.setNmColab("Colab setor null");
		colab.setCpfColab("45678912349");
		colab.setTelColab("21999999991");
		return colab;
	}
<<<<<<< HEAD
	
=======
>>>>>>> feeee9ee92fccb6901253205563b6a60167cf257
}
