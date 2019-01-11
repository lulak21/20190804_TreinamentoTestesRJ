require "calculadora_royalties"
require_relative "../models/venda"


describe CalculadoraRoyalties do
    describe ".calcular_royalties" do
        subject do 
            described_class.new.calcular_royalties(mes,ano)
        end

        before do
            allow(VendaRepository).to receive(:obtervendaspormeseano).and_return vendas
        end

        context "dado que não houveram vendas em fevereiro de 2010" do
            let :ano do
                2010
            end 
            let :mes do
                2
            end
            let :vendas do 
                []
            end

            it "retorna 0.00" do
                is_expected.to eql(0.00)
            end
        end

        context "dado que houve uma venda de 5000 em marco de 2010" do 
            let :ano do
                2010
            end 
            let :mes do
                3
            end

            let :vendas do 
                [
                    Venda.new(1, 5000, 3, 2010),
                ]
            end


            it "retorna 950" do
                
                is_expected.to eql(950.0)
            end
        end

        context "dado que houve uma venda de 30000 e de 55,59 em janeiro de 2010" do 
            let :ano do
                2010
            end 
            let :mes do
                1
            end

            let :vendas do 
                [
                    Venda.new(1, 30000, 1, 2010),
                    Venda.new(2, 55.59, 1, 2010)
                ]
            end

            it "retorna 5650,56" do
                
                is_expected.to eql(5650.56)
            end
        end 
    end
end