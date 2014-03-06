package uk.ac.cs.ncl.csc8109.project.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import uk.ac.cs.ncl.csc8109.project.data.FileExchangeServer;
import uk.ac.cs.ncl.csc8109.project.model.FileExchange;
import uk.ac.cs.ncl.csc8109.project.service.FileVerify;

@Path("/flie")
@RequestScoped
public class FileRest {
	@Inject
	private FileVerify verifyfile;
	@Inject
	private FileExchangeServer fileexchangeserver;

	/**
	 * POST the clientidsender , clientidreveiver SigA(H(doc)) file,and the doc.
	 * (this area I suggest the resteasy to do it) this link is how to do it
	 * http://blog.csdn.net/jackyrongvip/article/details/6670500
	 * 
	 * @return fileID
	 */
	@POST
	public String upLoadclientID() {
		String receiver = null;
		String sender = null;
		byte[] Eoo = null;
		byte[] doc = null;
		String filename = null;

		if (verifyfile.check(sender, receiver)) {
			if (verifyfile.verify(Eoo, doc, sender)) {
				String fileid = verifyfile.getFileID();
				String Url=verifyfile.generateURL(fileid);
				FileExchange fileexchange = new FileExchange();
				fileexchange.setClientRecever(receiver);
				fileexchange.setClientSender(sender);
				fileexchange.setFileID(fileid);
				fileexchange.setFilename(filename);
				fileexchange.setFileURL(Url);
				verifyfile.Stroage(fileexchange);
				verifyfile.storageDoc(Url, doc, Eoo, filename);
				verifyfile.giveURL(Url, fileid, receiver);
				return fileid;

			}

		}
		return null;
	}

}
