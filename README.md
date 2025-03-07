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

 - #### Uma API REST (Representational State Transfer) é um conjunto de regras que permite a comunicação entre sistemas diferentes através da WEB. Ela segue o modelo cliente-Servidor e utiliza o protocolo HTTP (HyperText Transfer Protocol) para troa de informações no formato JSON ou XML. 
 - #### Em termos simples, uma API REST permite que um sistema envie e e receba dados de outro sistema pela internet  de forma organizada e padronizada.

 <br>  

 - ### Princicpios definidos por Roy Fielding

 -  1. `Arquitetura cliente-servidor:` O cliente faz requisições para um servidor, e o servidor responde com os dados necessários.
 - 2. `Sem estado (Stateless):` Cada requisição deve conter todas as informações necessárias para ser processada. O servidor nao armazena o estado da requisição anterior.
 - 3. `Cacheável:` Para melhorar o desempenho, as respostas podem ser armazenadas em cache.
 - 4. `Interface Uniforme:`URLs bem definidas e métodos HTTP padronizados.
 - 5. `Sistema em camadas:`A API tem que estar bem definida entre as suas camadas: Banco de daods, servidor, segurança, etc.
 
   
   
   
   
   

