/*Write a program for simple RSA algorithm to encrypt and decrypt the data.*/

/*RSA algorithm*/
import java.io.*;
import java.math.*;
import java.nio.charset.*;
import java.util.*;

public class RSA {
    private BigInteger p, q, N, phi, e, d;
    private final int bitLength = 1024;
    private final Random r = new Random();

    public RSA() {
        p = BigInteger.probablePrime(bitLength, r);
        q = BigInteger.probablePrime(bitLength, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitLength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0) e = e.add(BigInteger.ONE);
        d = e.modInverse(phi);
    }

    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String text = scanner.nextLine();

        byte[] encrypted = rsa.encrypt(text.getBytes(StandardCharsets.UTF_8));
        byte[] decrypted = rsa.decrypt(encrypted);

        System.out.println("Encrypted: " + new BigInteger(encrypted).toString(16));
        System.out.println("Decrypted: " + new String(decrypted, StandardCharsets.UTF_8));
    }
}

/*OUTPUT:-
1.Prime number p is 135300281134717879746902808366541099903975251288789284334641807832207682871127271567920761055463729098924430287718421850746198499428795090338316070179909825871150136529664667741679224565002205330126017727809227066298450635996226617624131459287230966759830732923433622770966482580389693040579733621803440243969
2.Prime number q is 170562584752136934187250756707709666849234818501724317538955107998074989545033582877327247129830049849750916598428228136636890219614528565333654188553119948743435910519651826713018595370044199045107161079680301688990314455906280489353568884786496504824152441495041826797939948169147055493631177589953202830599
3.Public key is 7213875375108038073672044021293975116552046473166347060461685329555475221863979286020739066801430989540112524679688665752398505800679918797492724602732629
4.Private key is 1023289063268676675003449072500393039208459382322802680700731614917438721396140666246676991920886203548324527726189056503719860211034605091455352678223091981743421712993884339011094735886130392514148334790206925134627434958358052819633299212582327504398962772728040049042420140860964364438644651432492580422743897821761291862425154343255252583775026543171384094323231691736281136294303552307517561025433816717347431371791281087849264286227621150609745146508179071035602417184619084140537419568547987943501393721117769124162442581924784185567686609430632478656509370462194940451391673893318824171257060825753452343549
Enter the plain text: 
details are 1234
Encrypting string: details are 1234
String in bytes: 1001011169710510811532971141013249505152
Decrypting Bytes: 1001011169710510811532971141013249505152
Decrypted string: details are 1234

Prime number p is 109492990205505016202586262142923307783247049653299015586170621681856503761083884888528695222191678948878041905857409439803087048366321517665632099660164526889423571756222428986041425545271269918402688374073491000864036264121388747037462508960933193885668914392055760834105261571349765885220586249294171612057
Prime number q is 93399612207412436969434052573879362077001296732671115601019322320721918743646170142893414529142248100621518811452260973796980039890338073243510219537619027935273166103364972100049568478035350362075770492491148611826895972403818408662930716899590641308806028204738352163397228758697729876804042687524191528943
Public key is 8119350406182689658884493699975098797037650381105758941168105542564836602908836769468925573732813850917403491558512111708465544624034528481225595764959683
Private key is 1646613907477597622755563031371233833676548650988208613533354059595087263414781609760226724123721917746080305306947151587468685412435236353871419956817596174610644915651059746161678650413268778532936710071220044355444208355917492269519738970391019685334028387458739083768946929334083572374601153395964214626233848370913408413749783925297686969970393800283392478327780433521493600773671785118071235453350562128184421661607725168796679664700027887666114235337064970136736548322210694384567600258547349628841570102746588586925784012590584493071780827840785085854222142399589991793821810906202207476941901002997931306123
Enter the plain text: 
hello there
Encrypting string: hello there
String in bytes: 10410110810811132116104101114101
Decrypting Bytes: 10410110810811132116104101114101
Decrypted string: hello there
*/