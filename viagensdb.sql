SELECT
    cliente.nome,
    cliente.email,
    Endereco.rua,
    Endereco.cidade
FROM cliente
JOIN Endereco
    ON Endereco.id = cliente.endereco_id;