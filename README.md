# 💱 GeoConverter

**GeoConverter** é um projeto que oferece um conversor de moedas com interação via console. A aplicação fornece, no mínimo, 6 opções de conversão, com taxas obtidas em tempo real através de uma API externa.

## 🛠 Funcionalidades

- Conversão de moedas entre **BRL**, **USD**, **ARS**, **BOB**, **CLP** e **COP**.
- Obtenção das taxas de conversão de forma dinâmica e em tempo real, usando uma API externa.
- Interface simples de linha de comando para interação com o usuário.
  
## ⚙️ Pré-requisitos

Para utilizar o serviço, é necessário ter uma chave de API válida para a **ExchangeRate API**.

### 🔑 Como obter sua chave de API

1. Vá até o site da [ExchangeRate API](https://www.exchangerate-api.com/).
2. Cadastre-se e crie uma conta para obter a sua chave de API gratuita ou paga, dependendo do plano escolhido.
3. Após obter a chave, você poderá utilizá-la para fazer as requisições de conversão de moedas.

## 📝 Como configurar a chave de API no código

1. **Abra o arquivo `ExchangeRateApiClient.java`** no diretório `src/com/geoconverter/api`.

2. Dentro da classe `ExchangeRateApiClient`, localize a linha onde a chave de API é configurada. Substitua o valor de `YOUR_API_KEY` pela sua chave obtida no passo anterior.

   **Exemplo de código:**

   ```java
   public class ExchangeRateApiClient {

     // Substitua o valor da chave pela sua chave real da API
     private static final String YOUR_API_KEY = "KEY";
   ```
