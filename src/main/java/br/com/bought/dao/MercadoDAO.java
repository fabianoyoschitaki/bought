package br.com.bought.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.bought.common.MercadoVO;

public class MercadoDAO {

	private static List<MercadoVO> mercados = new ArrayList<MercadoVO>(); 
	private static int CONT = 1;
	static {
		mercados.add(new MercadoVO(1, "Carrefour", "O mercado carrefurto", "São Paulo", "SP", "Brasil", "100", "Avenida", "12345-000", "http://res.cloudinary.com/networkmi/image/upload/v1449290328/carrefour1_fwqwfq.gif", "carrefour0001"));
		mercados.add(new MercadoVO(2, "Extra", "O mercado a mais", "São Paulo", "SP", "Brasil", "200", "Avenida", "12345-000", "http://res.cloudinary.com/networkmi/image/upload/v1449290439/139881916514_fnrky7.jpg", "extra0001"));
		mercados.add(new MercadoVO(3, "Pão de Açúcar", "O mercado do pão diabético", "São Paulo", "SP", "Brasil", "300", "Avenida", "12345-000", "http://res.cloudinary.com/networkmi/image/upload/v1449290461/pao-de-acucar-logo_oy5zhs.jpg", "paodeacucar0001"));        
	}
	
	/**
	 * Devolve a lista de todos os mercados
	 * 
	 * @return
	 */
	public static List<MercadoVO> obterTodosMercados(){
		return mercados;
	}
	
	/**
	 * Adiciona novo mercado
	 * 
	 * @param mercado
	 * @return
	 */
	public static MercadoVO adicionarMercado(MercadoVO mercado){
		try {
			if (mercado.getId() == null) mercado.setId(CONT++);
			mercados.add(mercado);
		} catch (Exception e){
			System.out.println("Erro:" + e);
		}
		return mercado;
	}
	
	/**
	 * Retorna mercado pelo código do mercado QR code
	 * 
	 * @param qrCode
	 * @return
	 */
	public static MercadoVO obterMercadoPorQRCode(String qrCode){
		MercadoVO retorno = null;
		if (qrCode != null){
			for (MercadoVO mercado : mercados) {
				if (qrCode.equals(mercado.getQrCode())){
					retorno = mercado;
					break;
				}
			}
		}
		return retorno;	
	}

	/**
	 * Remove mercado pelo id
	 * 
	 * @param id
	 * @return
	 */
	public static MercadoVO removerMercadoPorId(Integer id) {
		MercadoVO retorno = null;
		try {
			if (id != null){
				for (MercadoVO mercado : mercados) {
					if (id.equals(mercado.getId())){
						retorno = mercado;
						mercados.remove(mercado);
						break;
					}
				}
			}
		} catch (Exception e){
			System.out.println("Erro:" + e);
		}
		return retorno;
	}
}
