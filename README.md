# N-Layer Architecture

- É um padrão de design que divide um sistema em múltiplas camadas, separando responsabilidades para melhor organização, escalabilidade e manutenção do código. 

# Quais são as principais camadas da arquitetura N-Layer?

 - #### 1. `Camada de apresentação (Presentation Layer):` Responsável pela interação com o usuário. Se for uma aplicação WEB, pode ser definida a partir do fronted, caso seja uma aplicação REST, pode ser definido a partir de controllers, como é usado no Spring Boot.
 - #### 2. `Camada de aplicação (Application Layer):` Ela define os fluxos e regras de orientação entre as camadas inferiores, ela orquestra as camadas services e repositorys. Um exemplo disso é no código que estamos trabalhando em sala de aula. Na classe LancheApplication é injetada as dependências das classes LancheService e LancheRepository, que será onde faremos o fluxo da orquestração.
 - #### 3. `Camada de serviço (Service Layer):` Basicamente é onde ficarão as regras de negócio e também é onde os dados serão processados antes de enviá-los ou armazená-los para outro local.
 - #### 4. `Camada de repositório (Repository Layer ou Data Access Layer - DAL):` Essa camada é responsável pelo acesso e manipulação de dados no banco de dados.
 - #### 5. `Camada de banco de dados (Data Layer):` É a camada onde ficará armazenado o banco de dados físico e é acessada pela camada repository.

    ### `Vantagens` da utilização da arquitetura de camadas:
    - Separação de responsabilidade.
    - Facilidade de manutenção.
    - Escalabilidade 
    - Testabilidade
    <br> <br> <br> <br> <br>
 
 

## `ApiREST ou ApiRESTFUL: O que é?`

 - #### Uma API REST (Representational State Transfer) é um conjunto de regras que permite a comunicação entre sistemas diferentes através da WEB. Ela segue o modelo cliente-Servidor e utiliza o protocolo HTTP (HyperText Transfer Protocol) para troca de informações no formato JSON ou XML. 
 - #### Em termos simples, uma API REST permite que um sistema envie e e receba dados de outro sistema pela internet  de forma organizada e padronizada.

 <br>  

 - ### Princicpios definidos por Roy Fielding

 - #### 1. `Arquitetura cliente-servidor:` O cliente faz requisições para um servidor, e o servidor responde com os dados necessários.
 - #### 2. `Sem estado (Stateless):` Cada requisição deve conter todas as informações necessárias para ser processada. O servidor nao armazena o estado da requisição anterior.
 - #### 3. `Cacheável:` Para melhorar o desempenho, as respostas podem ser armazenadas em cache.
 - #### 4. `Interface Uniforme:`URLs bem definidas e métodos HTTP padronizados.
 - #### 5. `Sistema em camadas:`A API tem que estar bem definida entre as suas camadas: Banco de daods, servidor, segurança, etc.
 <br>  <br>  <br>




 ## `Passo a passo para criar a camada Repository no Spring` 

 #### `1. Criação dos packages` Criar um os pacotes de cada camada: models, repositories, facade, application, controller.
 #### `2. Criando uma classe repository:` Declaramos a classe EmpresaRepository colocando a notação @Repository e criamos uma lista para armazenar as empresas.
 #### `3. Criar o metodo existsById:` Esse método vai verificar se existe uma empresa com base no id.
    
```java 
 public boolean existsById(int id) {
        return empresas.stream()
                .anyMatch(emp -> emp.getIdEmpresa() == id);
    }

    //Como o expressão empresas.get é boolean, não precisamos fazer um if else, apenas retorna-lá. ("se não for null ela retorna true") e usando a funçaõ stream e anymatch(boolean) a gente consegue procurar a empresa pelo id dela, e nao pelo id do indice da lista
```
#### `4. Criar o metodo buscarPorId:` Esse método retorna a empresa correspondente ao ID ou uma mensagem de erro:
```java
   public Object buscarPorId(int id) {
        try {
            if (existsById(id)) {
                for (Empresas empresa : empresas) {
                    if (empresa.getIdEmpresa() == id) {
                        return empresa;
                    }
                }
            }
            return "Não existe empresa com o id " + id;
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }


    // Usamos o metodo criado anteriormente para verificar se existe empresa com o id fornecido, o uso do for each permite que compare o id passado por parametro pelo proprio id da empresa, e nao pelo indice da lista.
```
#### `5. Criar o metodo listar:` Apenas retornar a lista com as empresas.
#### `6. Criar o metodo cadastrar:` Esse metodo adiciona uma nova empresa a lista.
#### `7. Criar o metodo deletar:` Esse metodo exclui uma empresa da lista baseada no id da empresa, e nao no index da lista.
```java
public void deletar(int id) {
        if (existsById(id)) {
            empresas.removeIf(emp -> emp.getIdEmpresa() == id);
        }
    }
```

## `Passo a passo para criar a camada Application no Spring` 

 #### `1. Criando uma classe Application:` Declaramos a classe EmpresaApplication colocando a notação @Componente e injetamos as dependências;
 #### `2. Implementar o método buscarPorId:` 
 #### `3. Implementar o método listar:` 
 #### `4. Implementar o método cadastrar:`
 #### `5. Implementar o método atualizar:`
 #### `6. Implementar o método excluir:` 

 <br> <br>
 
## `Passo a passo para criar a camada Facade no Spring` 

 #### `1. Criando uma classe Facade:` Declaramos a classe EmpresaFacade colocando a notação @Componente e injetamos as dependências;
 #### `2. Implementar o método buscarPorId:` 
 #### `3. Implementar o método listar:` 
 #### `4. Implementar o método cadastrar:`
 #### `5. Implementar o método atualizar:`
 #### `6. Implementar o método excluir:` 

