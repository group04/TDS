package uk.ac.cs.ncl.csc8109.project.service;

import javax.inject.Inject;

import uk.ac.cs.ncl.csc8109.project.data.ClientServer;

public class Verify {
	@Inject
	private ClientServer clientserver;
	@Inject
	private CodeExchange codeexchange;
	
/**
 * give the clientID file and the encryption file
 * return true  if the encryption file is come from the client  or false
 */
	public Boolean verify(byte[] eoo,byte[] doc,String ClientID){
		String publickey=clientserver.getKey(ClientID);
		byte[] pubkey=codeexchange.getbyte(publickey);
		//verify the eoo
		
		return null;
		
	}
}
