package com.romario.superprod.service.rels;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.Produto;
import com.romario.superprod.domain.Usuario;
import com.romario.superprod.domain.dto.rel.MaquinaRel;
import com.romario.superprod.domain.dto.rel.MoldeRel;
import com.romario.superprod.domain.dto.rel.ProducaoRel;
import com.romario.superprod.domain.dto.rel.ProdutoRel;
import com.romario.superprod.domain.dto.rel.UsuRel;
import com.romario.superprod.repository.MaquinaRepository;
import com.romario.superprod.repository.MoldeRepository;
import com.romario.superprod.repository.ProducaoRepository;
import com.romario.superprod.repository.ProdutoRepository;
import com.romario.superprod.repository.UsuarioRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class RelProducao {
	
	@Autowired
	private UsuarioRepository repoUsu;
	
	@Autowired
	private MaquinaRepository repoMaq;
	
	@Autowired
	private MoldeRepository repomolde;
	
	@Autowired
	private ProdutoRepository repoproduto;
	
	@Autowired
	private ProducaoRepository repoproducao;
	
	
	public byte[] maquina(Integer tenant) throws Exception {
		List<Maquina> convenios = repoMaq.maquina(tenant);
		List<MaquinaRel> convrels = new ArrayList<MaquinaRel>();
		for(Maquina conv: convenios) {
			MaquinaRel convrel = new MaquinaRel(conv);
			convrels.add(convrel);
			}		
		
			        
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("tenant", (tenant));
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/rel/maq.jasper");		
		JRBeanCollectionDataSource jrb = new JRBeanCollectionDataSource(convrels, false);
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,jrb);
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
		
	

	}
	
	public byte[] molde(Integer tenant) throws Exception {
		List<Molde> convenios = repomolde.molde(tenant);
		List<MoldeRel> convrels = new ArrayList<MoldeRel>();
		for(Molde conv: convenios) {
			MoldeRel convrel = new MoldeRel(conv);
			convrels.add(convrel);
		}		
		
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("tenant", (tenant));
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/rel/moldes.jasper");		
		JRBeanCollectionDataSource jrb = new JRBeanCollectionDataSource(convrels, false);
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,jrb);
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
		
		
		
	}
	
	public byte[] produto(Integer tenant) throws Exception {
		List<Produto> convenios = repoproduto.produto(tenant);
		List<ProdutoRel> convrels = new ArrayList<ProdutoRel>();
		for(Produto conv: convenios) {
			ProdutoRel convrel = new ProdutoRel(conv);
			convrels.add(convrel);
		}		
		
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("tenant", (tenant));
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/rel/produtos.jasper");		
		JRBeanCollectionDataSource jrb = new JRBeanCollectionDataSource(convrels, false);
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,jrb);
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
		
		
		
	}
	
	
	public byte[] usuario(Integer tenant) throws Exception {
		List<Usuario> listUsu = repoUsu.findAllList(tenant);
		List<UsuRel>listusurel = new ArrayList<UsuRel>();
		for (Usuario usu:listUsu ) {
			UsuRel usurel = new UsuRel(usu);
			listusurel.add(usurel);
		}
//		
			        
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("tenant", (tenant));
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/rel/usuarios.jasper");		
		JRBeanCollectionDataSource jrb = new JRBeanCollectionDataSource(listusurel, false);
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,jrb);
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
		
	}
	
	
	public byte[] relatorioproducao(LocalDate inicio, LocalDate fim, Integer tenant) throws Exception {
		List<Producao> dados = repoproducao.porDatas(inicio.toString(), fim.toString(), tenant);
		List<ProducaoRel> atendsRels = new ArrayList<ProducaoRel>();
		for(Producao aten: dados) {
			ProducaoRel atenRel = new ProducaoRel(aten);
				atendsRels.add(atenRel);
			}		
		
	        
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("dataInicio", Date.valueOf(inicio));
		parametros.put("dataFim", Date.valueOf(fim));
		parametros.put("tenant", (tenant));
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/rel/producao.jasper");		
		JRBeanCollectionDataSource jrb = new JRBeanCollectionDataSource(atendsRels, false);
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,jrb);
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}

}
