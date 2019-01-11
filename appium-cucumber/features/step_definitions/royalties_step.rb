Dado("que nao tem nenhuma operacao em andamento") do
  btn_del = find_element(id: 'del')
  btn_del.click
end

Quando("eu somo dois numeros") do
  btn_dois = find_element(id: 'digit_2')
  btn_mais = find_element(id: 'op_add')
  btn_igual = find_element(id: 'eq')
  btn_dois.click
  btn_mais.click
  btn_dois.click
  btn_igual.click
end

Então("a calculadora deve mostrar o resultado da soma") do
  resultadoElement = find_element(id: 'result')
  expect(resultadoElement.text).to eq('4')
end 