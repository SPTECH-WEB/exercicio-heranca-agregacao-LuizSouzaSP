package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(vagas > 0 && desenvolvedor.isFullstack() == true){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double totalSalarios = 0.0;

        for(Desenvolvedor d:desenvolvedores){
            totalSalarios += d.calcularSalario();
        }

        return totalSalarios;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtd = 0;
        for(Desenvolvedor d:desenvolvedores){
            if(d instanceof DesenvolvedorMobile){
                qtd++;
            }
        }
        return qtd;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedoresSalariosMaiorIgualQue = new ArrayList<>();
        for(Desenvolvedor d:desenvolvedores){
            if(d.calcularSalario() >= salario){
                desenvolvedoresSalariosMaiorIgualQue.add(d);
            }
        }
        return desenvolvedoresSalariosMaiorIgualQue;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        } else {
            Desenvolvedor desenvolvedorMenor = desenvolvedores.get(0);
            for (Desenvolvedor d : desenvolvedores) {
                if (d.calcularSalario() < desenvolvedorMenor.calcularSalario()) {
                    desenvolvedorMenor = d;
                }
            }
            return desenvolvedorMenor;

        }
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedorsTecnologia = new ArrayList<>();
        for(Desenvolvedor d:desenvolvedores){
            if(d instanceof DesenvolvedorWeb){
                if((((DesenvolvedorWeb) d).getBackend()).equalsIgnoreCase(tecnologia)){
                    desenvolvedorsTecnologia.add(d);
                } else if((((DesenvolvedorWeb) d).getFrontend()).equalsIgnoreCase(tecnologia)){
                    desenvolvedorsTecnologia.add(d);
                } else if ((((DesenvolvedorWeb) d).getSgbd()).equalsIgnoreCase(tecnologia)){
                    desenvolvedorsTecnologia.add(d);
                }
            } else if (d instanceof DesenvolvedorMobile){
                if((((DesenvolvedorMobile) d).getLinguagem()).equalsIgnoreCase(tecnologia)){
                    desenvolvedorsTecnologia.add(d);
                } else if ((((DesenvolvedorMobile) d).getPlataforma()).equalsIgnoreCase(tecnologia)){
                    desenvolvedorsTecnologia.add(d);
                }
            }
        }
        return desenvolvedorsTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double valorTotal = 0.0;

        for(Desenvolvedor d:desenvolvedores){
            if(d instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) d).getSgbd().equalsIgnoreCase(tecnologia)){
                    valorTotal += d.calcularSalario();
                } else if (((DesenvolvedorWeb) d).getBackend().equalsIgnoreCase(tecnologia)){
                    valorTotal += d.calcularSalario();
                } else if(((DesenvolvedorWeb) d).getFrontend().equalsIgnoreCase(tecnologia)){
                    valorTotal += d.calcularSalario();
                }
            } else if(d instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) d).getLinguagem().equalsIgnoreCase(tecnologia)){
                    valorTotal += d.calcularSalario();
                } else if(((DesenvolvedorMobile) d).getPlataforma().equalsIgnoreCase(tecnologia)){
                    valorTotal += d.calcularSalario();
                }
            }
        }
        return valorTotal;
    }
}
