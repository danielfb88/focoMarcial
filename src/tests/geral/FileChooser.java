package tests.geral;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooser {
	public static void main(String[] args) {
		String caminhoArquivo = "";
		JFileChooser arquivo = new JFileChooser();
		
		arquivo.setFileFilter(new javax.swing.filechooser.FileFilter() {
			//Filtro, converte as letras em minúsculas antes de comparar
			public boolean accept(File f){
			return f.getName().toLowerCase().endsWith(".wav") || f.isDirectory();
			}
			//Texto que será exibido para o usuário
			public String getDescription() {
			return "Arquivos de imagem (.wav)";
			}
			});
		
		int retorno = arquivo.showOpenDialog(null);
//		if (retorno == JFileChooser.APPROVE_OPTION) {
//			caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
//			JOptionPane.showMessageDialog(null, caminhoArquivo);
//		} else {
//			// não abriu
//		}
	}
}
