require "calculadora_comissao"
require "venda_repository"

class CalculadoraRoyalties
    def calcular_royalties(mes, ano)
        calculadoraComissao = CalculadoraComissao.new

        (VendaRepository.obtervendaspormeseano(mes, ano).reduce(0) do |acc,venda|
            acc + venda.valor - calculadoraComissao.calcular_comissao(venda.valor) 
        end * 0.2 * 100).floor/100.0
        
    end
end