# Rodando projeto localmente
./mvnw spring-boot:run

# Exemplo de request para obtenção de detalhes de viagem para hotéis de cidade específica
http://localhost:8080/api/v1/travels/?cityCode=7110&checkin=2019-10-10&checkout=2019-10-15&totalAdults=2&totalChilds=1

# Exemplo de request para obtenção de detalhes de viagem para hotel específico
http://localhost:8080/api/v1/travels/hotels/3?checkin=2019-10-10&checkout=2019-10-15&totalAdults=2&totalChilds=1