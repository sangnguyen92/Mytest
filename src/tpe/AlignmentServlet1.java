package tpe;


import java.io.IOException;
import java.net.URL;

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
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.ProteinSequence;
import org.biojava3.core.sequence.compound.AminoAcidCompound;
import org.biojava3.core.sequence.compound.AminoAcidCompoundSet;
import org.biojava3.core.sequence.io.FastaReaderHelper;


@SuppressWarnings({ "serial" })
public class AlignmentServlet1 extends HttpServlet implements Servlet{
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String QuSequen = request.getParameter("inQuSeq").trim();
		String SubSequen = request.getParameter("inSubSeq");
		String QuFile = request.getParameter("qufile");
		String SubFile = request.getParameter("subfile");
		
		
		String err ="";
		String url="";
		
		if(QuSequen.equals("") && SubSequen.equals("") && QuFile.equals("") && SubFile.equals("")){
			err += "You may enter two sequence!";
		} else if(!QuSequen.equals("") && SubSequen.equals("") && SubFile.equals("")){
			err += "You may enter two sequence!";
		} else if(!SubSequen.equals("") && QuFile.equals("") && QuSequen.equals("")){
			err += "You may enter two sequence!";
		} else if(!QuSequen.equals("") && !SubSequen.equals("") && !QuFile.equals("") && !SubFile.equals("")){
			err += "Choix only enter ou upload file!";
		} else if(!QuSequen.equals("") && (SubSequen.equals("") || SubFile.equals("")) && !QuFile.equals("")){
			err +="Choix only enter ou upload file";
		} else if((QuSequen.equals("") || QuFile.equals("")) && !SubSequen.equals("") && !SubFile.equals("")){
			err +="Choix only enter ou upload file";
		}
		
		if(err.length() > 0){
			request.setAttribute("err", err);
		}
		
		try {

				if(err.length()==0){
					if(!QuSequen.equals("") && !SubSequen.equals("") && QuFile.equals("") && SubFile.equals("")){						
						ProteinSequence target = new ProteinSequence(SubSequen,
					              AminoAcidCompoundSet.getAminoAcidCompoundSet());
					//	request.setAttribute("target", target.toString());
						 
						ProteinSequence query = new ProteinSequence(QuSequen,
					              AminoAcidCompoundSet.getAminoAcidCompoundSet());
					//	request.setAttribute("query", query.toString());
						
						SubstitutionMatrix<AminoAcidCompound> matrix1 = new SimpleSubstitutionMatrix<AminoAcidCompound>();

					      SimpleGapPenalty gapP = new SimpleGapPenalty();
					      gapP.setOpenPenalty((short)5);
					      gapP.setExtensionPenalty((short)2);

					      SequencePair<ProteinSequence, AminoAcidCompound> psa =
					              Alignments.getPairwiseAlignment(query, target,
					                      PairwiseSequenceAlignerType.GLOBAL, gapP, matrix1);
					      SequencePair<ProteinSequence, AminoAcidCompound> psa1 =
					              Alignments.getPairwiseAlignment(query, target,
					                      PairwiseSequenceAlignerType.LOCAL, gapP, matrix1);
					      
					      String[] k_1 = new String[query.toString().length()/60+1];	
				        	int i=0;
				        	for(;i<query.toString().length()/60;i++){
				        		k_1[i]=(String)query.toString().substring((i*60), (i+1)*60);
				        	}
				          	if(i*60<query.toString().length()){
				          		k_1[i]=(String)query.toString().substring((i)*60);
				          	}
					      
				          	String[] k1_1 = new String[target.toString().length()/60+1];	
				        	int i1=0;
				        	for(;i1<target.toString().length()/60;i1++){
				        		k1_1[i1]=(String)target.toString().substring((i1*60), (i1+1)*60);
				        	}
				          	if(i1*60<target.toString().length()){
				          		k1_1[i1]=(String)target.toString().substring((i1)*60);
				          	}
				          	
				          	String orPair=psa.toString().substring(0, psa.toString().length()/2);
				          	String subPair=psa.toString().substring(psa.toString().length()/2);
				          	String[] orPair_1 = new String[orPair.toString().length()/100+1];	
				          	String[] subPair_1= new String[subPair.toString().length()/100+1];
				          	
				          	int i2=0;
				        	for(;i2<orPair.toString().length()/100;i2++){
				        		orPair_1[i2]=(String)orPair.toString().substring((i2*100), (i2+1)*100);
				        	}
				          	if(i2*100<orPair.toString().length()){
				          		orPair_1[i2]=(String)orPair.toString().substring((i2)*100);
				          	}
				          	
				          	int i3=0;
				        	for(;i3<subPair.toString().length()/100;i3++){
				        		subPair_1[i3]=(String)subPair.toString().substring((i3*100), (i3+1)*100);
				        	}
				          	if(i3*100<subPair.toString().length()){
				          		subPair_1[i3]=(String)subPair.toString().substring((i3)*100);
				          	}
				          	
				          	
				          	String orPair1=psa1.toString().substring(0, psa1.toString().length()/2);
				          	String subPair1=psa1.toString().substring(psa1.toString().length()/2);
				          	
				          	String[] orPair1_1 = new String[orPair1.toString().length()/100+1];	
				          	String[] subPair1_1= new String[subPair1.toString().length()/100+1];
				          	
				          	int i21=0;
				        	for(;i21< orPair1.toString().length()/100;i21++){
				        		orPair1_1[i21]=(String)orPair1.toString().substring((i21*100), (i21+1)*100);
				        	}
				        	
				          	if(i21*100 < orPair1.toString().length()){
				          		orPair1_1[i21]=(String)orPair1.toString().substring((i21)*100);
				          	}
				          	
				          	int i31=0;
				        	for(;i31<subPair1.toString().length()/100;i31++){
				        		subPair1_1[i31]=(String)subPair1.toString().substring((i31*100), (i31+1)*100);
				        	}
				          	if(i31*100<subPair1.toString().length()){
				          		subPair1_1[i31]=(String)subPair1.toString().substring((i31)*100);
				          	}
				          	
				          	request.setAttribute("target", k1_1);
				          	request.setAttribute("query", k_1);
				          	request.setAttribute("orPair",orPair_1);
				        	request.setAttribute("subPair", subPair_1);
				        	request.setAttribute("orPair1",orPair1_1);
				        	request.setAttribute("subPair1", subPair1_1);
				        	
							url="/alignment.jsp";
					}
					
					else if(QuSequen.equals("") && SubSequen.equals("") && !QuFile.equals("") && !SubFile.equals("")){
						
						if(QuFile.equals("Q21691.fasta")){
							QuFile = "Q21691";
						}else if(QuFile.equals("A8WS47.fasta")){
							QuFile = "A8WS47";
						}else if(QuFile.equals("O48771.fasta")){
							QuFile = "O48771";
						}else if(QuFile.equals("tap.fasta")){
							QuFile = "tap";
						}else{
							QuFile="Q21691";
						}
						
						if(SubFile.equals("Q21691.fasta")){
							SubFile = "Q21691";
						}else if(SubFile.equals("A8WS47.fasta")){
							SubFile = "A8WS47";
						}else if(SubFile.equals("O48771.fasta")){
							SubFile = "O48771";
						}else if(SubFile.equals("tap1.fasta")){
							SubFile = "tap1";
						}
						else{
							SubFile = "A8WS47";
						}
						
						String[] ids = new String[] {QuFile,SubFile};
				        try {
				        	ProteinSequence s1 = getSequenceForId(ids[0]),s2=  getSequenceForId(ids[1]);
				        	SequencePair<ProteinSequence, AminoAcidCompound> pair=getAlignPairGlobal(ids[0], ids[1]);
				        	SequencePair<ProteinSequence, AminoAcidCompound>  pair1=getAlignPairLocal(ids[0], ids[1]);
				        	
				        	//response.getWriter().print(s1);
				        	
				        	String[] s_1 = new String[s1.toString().length()/60+1];	
				        	int i=0;
				        	for(;i<s1.toString().length()/60;i++){
				        		s_1[i]=(String)s1.toString().substring((i*60), (i+1)*60);
				        	}
				          	if(i*60<s1.toString().length()){
				          		s_1[i]=(String)s1.toString().substring((i)*60);
				          	}
				          	
				          	String[] s_2 = new String[s2.toString().length()/60+1];	
				        	int i1=0;
				        	for(;i1<s2.toString().length()/60;i1++){
				        		s_2[i1]=(String)s2.toString().substring((i1*60), (i1+1)*60);
				        	}
				          	if(i1*60<s2.toString().length()){
				          		s_2[i1]=(String)s2.toString().substring((i1)*60);
				          	}
				          	
				          	String orPair=pair.toString().substring(0, pair.toString().length()/2);
				          	String subPair=pair.toString().substring(pair.toString().length()/2);
				          	String[] orPair_1 = new String[orPair.toString().length()/100+1];	
				          	String[] subPair_1= new String[subPair.toString().length()/100+1];
				          	
				          	int i2=0;
				        	for(;i2<orPair.toString().length()/100;i2++){
				        		orPair_1[i2]=(String)orPair.toString().substring((i2*100), (i2+1)*100);
				        	}
				          	if(i2*100<orPair.toString().length()){
				          		orPair_1[i2]=(String)orPair.toString().substring((i2)*100);
				          	}
				          	
				          	int i3=0;
				        	for(;i3<subPair.toString().length()/100;i3++){
				        		subPair_1[i3]=(String)subPair.toString().substring((i3*100), (i3+1)*100);
				        	}
				          	if(i3*100<subPair.toString().length()){
				          		subPair_1[i3]=(String)subPair.toString().substring((i3)*100);
				          	}
				          	
				          	String orPair1=pair1.toString().substring(0, pair1.toString().length()/2);
				          	String subPair1=pair1.toString().substring(pair1.toString().length()/2);
				          	
				          	String[] orPair1_1 = new String[orPair1.toString().length()/100+1];	
				          	String[] subPair1_1= new String[subPair1.toString().length()/100+1];
				          	
				          	int i21=0;
				        	for(;i21< orPair1.toString().length()/100;i21++){
				        		orPair1_1[i21]=(String)orPair1.toString().substring((i21*100), (i21+1)*100);
				        	}
				        	
				          	if(i21*100 < orPair1.toString().length()){
				          		orPair1_1[i21]=(String)orPair1.toString().substring((i21)*100);
				          	}
				          	
				          	int i31=0;
				        	for(;i31<subPair1.toString().length()/100;i31++){
				        		subPair1_1[i31]=(String)subPair1.toString().substring((i31*100), (i31+1)*100);
				        	}
				          	if(i31*100<subPair1.toString().length()){
				          		subPair1_1[i31]=(String)subPair1.toString().substring((i31)*100);
				          	}
				          	
				          	
				          	
//				          	for(int k=0;k<orPair1.toString().length()/60+1;k++){
//				          		response.getWriter().print(subPair1_1[k]);
//				          		response.getWriter().print("\n");
//				          	}
				          	
				        	request.setAttribute("s1", s_1);
				        	request.setAttribute("s2", s_2);
				        	request.setAttribute("orPair",orPair_1);
				        	request.setAttribute("subPair", subPair_1);
				        	request.setAttribute("orPair1",orPair1_1);
				        	request.setAttribute("subPair1", subPair1_1);
				        	
				    		url="/alignment1.jsp";
				
				        } catch (Exception e){
				            e.printStackTrace();
				        }				       
					}
					
				}else{
					
					response.getWriter().print(err);
				}
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(url);
				rd.forward(request, response);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	  
	}
	//@SuppressWarnings("unused")
	private static SequencePair<ProteinSequence, AminoAcidCompound> getAlignPairGlobal(String id1, String id2) throws Exception {
        ProteinSequence s1 = getSequenceForId(id1), s2 = getSequenceForId(id2);
        SubstitutionMatrix<AminoAcidCompound> matrix = new SimpleSubstitutionMatrix<AminoAcidCompound>();
        SequencePair<ProteinSequence, AminoAcidCompound> pair = Alignments.getPairwiseAlignment(s1, s2,
                PairwiseSequenceAlignerType.GLOBAL, new SimpleGapPenalty(), matrix);
        
//       System.out.printf("%n%s vs %s%n%s", pair.getQuery().getAccession(), pair.getTarget().getAccession(), pair);
        int half=pair.toString().length()/2;
        int number_of_charactors=100;
        int numberOfSubSequence=half/number_of_charactors;
        String original=pair.toString().substring(0,half);
        String stringpair=pair.toString().substring(half);
        System.out.println("original:"+original);
        System.out.println("pair:"+stringpair);
        int i=0;        
        for(;i<numberOfSubSequence;i++){
        	System.out.println(original.substring(i*number_of_charactors,(i+1)*number_of_charactors));
        	System.out.println(stringpair.substring(i*number_of_charactors,(i+1)*number_of_charactors));        	
        }
        if(i*number_of_charactors<half){
        	System.out.print(original.substring(i*number_of_charactors));
        	System.out.print(stringpair.substring(i*number_of_charactors));        	
        }
        return pair;
	}
	private static SequencePair<ProteinSequence, AminoAcidCompound> getAlignPairLocal(String id1, String id2) throws Exception {
        ProteinSequence s1 = getSequenceForId(id1), s2 = getSequenceForId(id2);
        SubstitutionMatrix<AminoAcidCompound> matrix = new SimpleSubstitutionMatrix<AminoAcidCompound>();
        SequencePair<ProteinSequence, AminoAcidCompound> pair = Alignments.getPairwiseAlignment(s1, s2,
                PairwiseSequenceAlignerType.LOCAL, new SimpleGapPenalty(), matrix);
       System.out.printf("%n%s vs %s%n%s", pair.getQuery().getAccession(), pair.getTarget().getAccession(), pair);
        return pair;
	}
 
    private static ProteinSequence getSequenceForId(String uniProtId) throws Exception {
     URL uniprotFasta = new URL(String.format("http://localhost:8888/text/%s.fasta", uniProtId)); 
//    	URL uniprotFasta = new URL(String.format("http://www.uniprot.org/uniprot/%s.fasta", uniProtId));
    	
//    	URL uniprotFasta = new URL("http://www.uniprot.org/uniprot/"+uniProtId+".fasta");
//        FileInputStream inputdata=new FileInputStream(new File("/home/sangnguyen/data/"+uniProtId+".fasta"));
        ProteinSequence seq = FastaReaderHelper.readFastaProteinSequence(uniprotFasta.openStream()).get(uniProtId);
//        ProteinSequence seq = FastaReaderHelper.readFastaProteinSequence(inputdata).get(uniProtId);
        System.out.printf("id : %s %s%n%s%n", uniProtId, seq, seq.getOriginalHeader());
        return seq;
    }
	
}
	


