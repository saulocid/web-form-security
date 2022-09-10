# web-form-security
Formulario de autenticação usando criptografia do lado do cliente com Java (Spring boot) e JavaScript (Puro)

O exemplo foi de um formulario de login mas pode ser feito com qualquer comunicação entre cliente-servidor

# Corpo da requisição do cliente (front-end) capturada com sniffer de rede
<img src="https://user-images.githubusercontent.com/95967506/189457129-51517eee-318e-4bf8-92f7-961ad8a91ec6.jpeg" alt="Corpo da resquição HTTP do lado do cliente"/>

# Servidor (back-end) após fazer a descriptografia (para verificar as credenciais de login e autenticar o usuario)
<img src="https://user-images.githubusercontent.com/95967506/189457183-4252bc67-1fb4-4a60-9581-b0ab8f0b5725.jpeg" alt="Servidor após descriptografar"/>

# Porque usar criptografia na requisição?
Para ajudar a evitar ataques de força bruta (brutte-forçe)

Para que pessoas que estão analizando o trafego de rede não possam ver e se apropriarem de informações valiosas (como as de login, por exemplo)

Para dificultar que pessoas consigam replicar a comunicação com clientes http como o cULR, ajudando a fazer com que o programa funcione do jeito desejado

# Detalhes
A key responsavel pela criptografia/descriptografia é gerada no servidor para cada sessão (cookie) e só funcionará para aquela sessão

Caso a pagina seja recarregada, uma nova key será gerada, fazendo com que a antiga sejá invalidada

O servidor após descriptografar o corpo da requisição compara uma informação passada no cabeçalho com uma do corpo da requisição 

Após o usuario se autenticar,  ele será redirecionado para uma pagina falando que ele está altenticado e poderá acessar qualquer outro caminho do servidor

O usuario e a senha são "security"
