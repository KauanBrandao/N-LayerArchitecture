package com.example.demo.services;

import com.example.demo.entities.Lanche;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class LancheService {
    private String filePath = "C:\\Users\\k4uan\\Pictures";

    public Lanche getById(int id) {
        return null;
    }

    public boolean exists(int id) {
        return true;
    }

    private String getFileExtension(Path path) {
        String filename = path.getFileName().toString();
        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "";
        }

        return filename.substring(lastDotIndex + 1);
    }

    public boolean salvar(Lanche lanche) {
        Path path = Paths.get(lanche.getImagem());


        Path pastaDestino = Paths.get(filePath);
        if (!Files.exists(pastaDestino)) {
            try {
                Files.createDirectories(pastaDestino);
                System.out.println("Diretório de imagens criado: " + pastaDestino);
            } catch (IOException e) {
                System.err.println("Erro ao criar diretório de imagens: " + e.getMessage());
                return false;
            }
        }


        Path destino = Paths.get(String.format("%s\\%d.%s", filePath, lanche.getCodigo(), getFileExtension(path)));

        if (Files.exists(path)) {
            try {
                Files.copy(path, destino, StandardCopyOption.REPLACE_EXISTING);
                lanche.setImagem(destino.toString());
                System.out.println("Imagem salva com sucesso em: " + destino);
                return true;
            } catch (IOException e) {
                System.err.println("Erro ao salvar a imagem: " + e.getMessage());
                return false;
            }
        }

        return false;
    }


    public void excluir(int codigo, Lanche lanche) {
        Path path = Paths.get(lanche.getImagem());

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                System.err.println("Erro ao excluir o arquivo: " + e.getMessage());            }
        }
    }

    public void atualizar(int id, Lanche lanche) {
        Path path = Paths.get(lanche.getImagem());

        try{
            if(Files.exists(path)){
                Files.delete(path);
                lanche.setImagem(path.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    }







