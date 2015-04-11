package relatorios;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import model.Consulta;
import net.sf.jasperreports.engine.JRException;
import utilidades.ConnectionFactory;
import utilidades.ReportUtils;

/**
 * Ponto de entrada do projeto.
 *
 * @author David Buzatto
 */
public class ExecutaRelatorio {

    String rel = "";

    
    public void abrirRelatorioClientes(String relatorio) {

        rel = relatorio;
        /*
         * Obtendo o arquivo do relatório. Note que estamos utilizando um
         * InputStream para obter o arquivo que está dentro do nosso projeto.
         * Fazendo isso, não teremos problema quando nosso projeto for
         * empacotado em um .jar.
         *
         * Note que o caminho do .jasper inicia com /, ou seja, a raiz da
         * localização das classes compiladas do nosso projeto (o pacote
         * default).
         *
         * Utilize a aba Files (canto superior esquerdo) e veja que os arquivos
         * .jasper e .jrxml são copiados para o diretório /build/classes e por
         * consequencia para o .jar que for criado.
         *
         * Se não os estiver vendo, mande dar um Clean and Build no projeto
         * (botão direito no nó raiz do projeto, Clean and Build (Limpar e
         * Construir)
         *
         */
        InputStream inputStream = getClass().getResourceAsStream(rel);

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();

        try {

            // abre o relatório
            ReportUtils.openReport("Relatorio de Venda", inputStream, parametros,
                    ConnectionFactory.getConnection());

        } catch (JRException exc) {
            exc.printStackTrace();
        }

    }

//    public void abrirRelatorioExame(Consulta consulta){
//    //InputStream inputStream = getClass().getResourceAsStream("RelatorioParcelasConvenio.jasper");
//        InputStream inputStream = getClass().getResourceAsStream("RelatorioExame.jasper");
//        Map<String, Object> parametros = new HashMap<String, Object>();
//        parametros.put("CONSULTA", consulta.getIdconsulta());
//        try {
//            // abre o relatório
//            ReportUtils.openReport("Exame", inputStream, parametros, ConnectionFactory.getConnection());
//        } catch (JRException exc) {
//            exc.printStackTrace();
//        }
//    }
    
    public void abrirRelatorioReceita(Consulta consulta, String titulo, String texto){
    //InputStream inputStream = getClass().getResourceAsStream("RelatorioParcelasConvenio.jasper");
        InputStream inputStream = getClass().getResourceAsStream("RelatorioReceita.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("CONSULTA", consulta.getIdconsulta());
        parametros.put("IDADE", consulta.getIdpaciente().getIdade());
        parametros.put("TITULO", titulo);
        parametros.put("TEXTO", texto);
        try {
            // abre o relatório
            ReportUtils.openReport(titulo, inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            exc.printStackTrace();
        }
    }
    
    

    public void abrirRelatorio(String relatorio, String titulo) {
        InputStream inputStream = getClass().getResourceAsStream("testeRelatorio2.jasper");
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
            // abre o relatório
            ReportUtils.openReport(titulo, inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            exc.printStackTrace();
        }
    }
    
}
