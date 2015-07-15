package tpe;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.biojava3.alignment.Alignments;
import org.biojava3.alignment.SimpleGapPenalty;
import org.biojava3.alignment.SimpleSubstitutionMatrix;
import org.biojava3.alignment.Alignments.PairwiseSequenceAlignerType;
import org.biojava3.alignment.template.Profile;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.ProteinSequence;
import org.biojava3.core.sequence.compound.AminoAcidCompound;
import org.biojava3.core.sequence.compound.AminoAcidCompoundSet;
import org.biojava3.core.sequence.io.FastaReader;
import org.biojava3.core.sequence.io.FastaReaderHelper;
import org.biojava3.core.sequence.io.FileProxyProteinSequenceCreator;
import org.biojava3.core.sequence.io.GenericFastaHeaderParser;


@SuppressWarnings({ "serial" })
public class MultiAlignmentServlet extends HttpServlet implements Servlet{
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String QuFile = request.getParameter("qufile");
		
		String err ="";
//		String url="";
		
		if(QuFile.equals("")){
			err += "You may enter a file!";
		}
		
		if(err.length() > 0){
			request.setAttribute("err", err);
		}
		
		try {

				if(err.length()==0){
					
						QuFile="ts1.small";
				}
					else{
					
					response.getWriter().print(err);
				}
//				RequestDispatcher rd = getServletContext()
//						.getRequestDispatcher(url);
//				rd.forward(request, response);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	  
	}
	
	
}
	


