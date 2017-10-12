package br.com.ippontadareia.cancioneiroippa.songs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;

/**
 * Created by lucasgasparquaresma on 2/13/17.
 */
public class SongList {
    public static SongList ourInstance = new SongList();

    public static SongList getInstance() {
        return ourInstance;
    }

    public SongList() {
    }

    private List<String> listTitles;
    private List<String> listLyrics;

    public List<Cantico> fillSongList(){

        listTitles = Arrays.asList("1 Crônicas 29.11-13 | Chefe sobre todos", "Daniel 2.20-23 | Seja bendito o nome de Deus", "Salmo 1 | Bem-aventurado o justo", "Salmo 10 (Sossegai)", "Salmo 16 (Tu és fiel Senhor)", "Salmo 32 | Enquanto calei meus pecados", "Salmo 42 | Como suspira a corça", "Salmo 48 | Grande é o Senhor", "Salmo 70 | Somente Cristo", "Salmo 78 | O que ouvimos e aprendemos",
                "Salmo 84 | Quão amáveis", "Salmo 96 | Cantai ao Senhor", "Salmo 11", "Salmo 106 | Rendei graças ao Senhor", "Salmo 115 | Não a nós, Senhor", "Salmo 117 (Vós criaturas de Deus Pai)", "Mateus 6.33 | Primeiro o reino de Deus", "Salmo 42", "João 14.21 | Aquele que me ama", "Romanos 8.35-39 | Quem nos separará",
                "Romanos 10.4 | O fim da Lei é Cristo", "Romanos 11.33-36 | Profundidade do ser de Deus", "1 Timóteo 3.16 | Aquele que foi manifestado", "1 João 1.9 | Se confessarmos", "Judas 24,25 | Majestade e Glória", "Apocalipse 5.13 | Ao que está assentado", "Apocalipse 15.3, 4 | Grandes são as tuas obras", "Salmo 137", "Maravilhosa Graça", "Cheguemo-nos, pois",
                "Aleluia, Salvação e Glória", "Salmo 15b", "Salmo 2", "Só em Jesus confiarei", "Salmo 19", "Eis o Cordeiro assentado em seu trono", "Eis o Cordeiro", "Salmo 40", "Salmo 12", "Salmo 61",
                "Salmo 139", "Salmo 37", "Salmo 103", "Salmo 122", "Salmo 46", "Me achego a Ti", "Salmo 24", "Salmo 85", "Minh’alma canta ao Senhor", "Salmo 16",
                "Deus, Tu és meu Deus", "Salmo 142", "Salmo 146", "Salmo 121", "Salmo 145", "Salmo 18", "Salmo 8", "Salmo 3 (Amazing Grace)", "Salmo 11", "Fale Ó Deus");


        listLyrics = Arrays.asList("Tua, Senhor, é a grandeza e o poder\n" +
                        "A honra, a vitória e a majestade\n" +
                        "Porque Teu é tudo quanto há nos céus e na terra\n" +
                        "Teu, Senhor, é o reino, e Tu te exaltaste\n" +
                        "Por chefe sobre todos\n" +
                        "\n" +
                        "Riquezas e glórias vêm de Ti\n" +
                        "Tu dominas sobre tudo\n" +
                        "Na Tua mão há força e poder\n" +
                        "Contigo está o engrandecer\n" +
                        "E a tudo dar força\n" +
                        "\n" +
                        "Agora, pois, oh nosso Deus\n" +
                        "Graças te damos, e louvamos o Teu glorioso nome\n" +
                        "Graças te damos, e louvamos o Teu glorioso nome",

                "Seja bendito o nome de Deus para sempre (2X)\n" +
                        "Porque dele é a sabedoria e a força (2X)\n" +
                        "\n" +
                        "Ele muda o tempo e as horas\n" +
                        "Remove reis, estabelece reis, o Senhor\n" +
                        "\n" +
                        "Ele dá sabedoria aos sábios e entendidos (2X)\n" +
                        "Conhece o mais profundo e es- condido (2X)\n" +
                        "Conhece o que está em trevas Com ele habita toda a luz, o Senhor\n" +
                        "\n" +
                        "Oh Deus de meus pais eu te louvo\n" +
                        "Oh Deus de meus pais te celebro Porque tu me deste sabedoria e força\n" +
                        "(2X)",

                "Bem aventurado aquele que não anda\n" +
                        "Segundo o conselho dos ímpios\n" +
                        "Não se detém no caminho dos pecadores\n" +
                        "Nem se assenta na roda dos escarnecedores\n" +
                        "\n" +
                        "Antes tem o seu prazer na lei do Senhor\n" +
                        "E na sua lei medita dia e noite\n" +
                        "Ele será como árvore plantada\n" +
                        "Junto a ribeiros de águas\n" +
                        "\n" +
                        "A qual dá o seu fruto na estação apropriada\n" +
                        "E cujas folhas não caem\n" +
                        "E tudo quanto fizer prosperará (2x)",

                "Por que, Senhor, ficas longe\n" +
                        "Te escondes na provação?\n" +
                        "Os ímpios com grande arrogância\n" +
                        "Ao pobre vêm perseguir\n" +
                        "Nas próprias tramas que urdiram\n" +
                        "Presas, pois, venham ser\n" +
                        "Pois se vangloria o perverso\n" +
                        "Da sua cobiça vil\n" +
                        "\n" +
                        "Blasfema o avarento contra o Senhor\n" +
                        "E o maldiz, E o maldiz\n" +
                        "Não investiga o perverso, pois\n" +
                        "Que Deus não existe, é seu cogitar\n" +
                        "Tem sempre os caminhos a prosperar\n" +
                        "Estão muito longe os juízos teus\n" +
                        "E zomba dos oponentes seus\n" +
                        "Pois, pra si diz assim:\n" +
                        "Abalos nunca jamais terei nas gerações\n" +
                        "\n" +
                        "Tem ele cheia a sua boca\n" +
                        "De enganos e maldição\n" +
                        "Insulto debaixo da língua\n" +
                        "Pecado e transgressão\n" +
                        "Monta tocaia nas vilas\n" +
                        "A fim de espreitar\n" +
                        "Trucida inocentes no ermo\n" +
                        "Qual fera a emboscar\n" +
                        "\n" +
                        "Na rede o pobre já enlaçou,\n" +
                        "E o prendeu e o prendeu\n" +
                        "Baixa e se arrasta, e em seu poder\n" +
                        "Caíram aflitos... Diz ele a pensar:\n" +
                        "Não lembra o Senhor, nem jamais verá\n" +
                        "O rosto virou e logo esqueceu\n" +
                        "Levanta oh Deus ergue a tua mão\n" +
                        "Oh, Senhor, oh Senhor\n" +
                        "Dos pobres não venhas te esquecer, oh, meu Senhor\n" +
                        "\n" +
                        "Por que razão fica o ímpio\n" +
                        "Desprezando ao Senhor\n" +
                        "Pensando que Deus não se importa?\n" +
                        "Mas tens visto, oh Senhor\n" +
                        "Ao sofrimento atentas\n" +
                        "Para os tomar nas mãos\n" +
                        "A Ti se entrega o pobre\n" +
                        "Do órfão és Defensor\n" +
                        "\n" +
                        "Quebranta o braço do homem mau\n" +
                        "transgressor, transgressor\n" +
                        "Sonda-lhes toda maldade até\n" +
                        "Não mais encontrar\n" +
                        "Rei eterno é o Senhor\n" +
                        "Da terra de Deus somem-se as nações\n" +
                        "Dos mansos Tu tens escutado a voz\n" +
                        "E firmarás os seus corações\n" +
                        "Seu clamor ouvirás\n" +
                        "E assim ninguém lhes trará terror, pois justo és",

                "Guarda-me, oh Deus, pois em Ti eu me abrigo\n" +
                        "Minh’alma diz que Tu és meu Senhor\n" +
                        "Além de Ti outro bem eu não tenho\n" +
                        "E nos teus santos está meu prazer\n" +
                        "\n" +
                        "Há muitas punições, penalidades mil\n" +
                        "Pra quem por deuses trocar o Senhor\n" +
                        "Jamais darei sacrifício a tais deuses\n" +
                        "A quem meus lábios não pronunciarão\n" +
                        "\n" +
                        "És minha taça, Senhor, minha herança\n" +
                        "Da minha sorte o arrimo Tu és\n" +
                        "Tenho divisas em áreas amenas\n" +
                        "Minha herança é formosa e sem par\n" +
                        "\n" +
                        "Bendigo o meu Senhor, que a mim conselhos traz\n" +
                        "E à noite o coração vem me ensinar\n" +
                        "Tenho o Senhor sempre à minha presença\n" +
                        "Ele à direita, abalado não sou\n" +
                        "\n" +
                        "Meu coração bem alegre exulta\n" +
                        "Meu corpo a salvo repouso terá\n" +
                        "Minh’alma não deixarás no abismo\n" +
                        "Nem o teu Santo provar corrupção\n" +
                        "\n" +
                        "Tu me farás saber por onde devo andar\n" +
                        "Sim, o caminho da vida enxergar\n" +
                        "Há pleno gozo na tua presença\n" +
                        "Na tua destra delícias sem fim",

                "Enquanto eu calei o meu pecado\n" +
                        "Envelheci, eu sei, de tão cansado\n" +
                        "\n" +
                        "Porque a tua mão pesava sobre mim\n" +
                        "E o meu vigor chegou ao fim\n" +
                        "O meu pecado, então, eu não mais ocultei\n" +
                        "Do meu Senhor e Rei\n" +
                        "\n" +
                        "Assim eu confessei o meu pecado\n" +
                        "E pelo sangue de Jesus eu fui lavado\n" +
                        "\n" +
                        "Porque a tua mão pesava sobre mim\n" +
                        "E o meu vigor chegou ao fim\n" +
                        "O meu pecado, então, eu não mais ocultei\n" +
                        "Do meu Senhor e Rei",

                "Como suspira a corça\n" +
                        "Pelas correntes das águas\n" +
                        "Como suspira a corça\n" +
                        "Pelas correntes das águas\n\n" +
                        "Assim por Ti, oh Deus\n" +
                        "Suspira minh’alma\n" +
                        "Assim por Ti, oh Deus\n" +
                        "Suspira minh’alma\n\n" +
                        "A minha alma tem sede\n" +
                        "Sede de Deus do Deus vivo\n" +
                        "A minha alma tem sede\n" +
                        "Sede de Deus do Deus vivo\n\n" +
                        "Assim por Ti, oh Deus\n" +
                        "Suspira minh’alma\n" +
                        "Assim por Ti, oh Deus\n" +
                        "Suspira minh’alma",

                "Grande é o Senhor e mui digno de louvor\n" +
                        "Na cidade do nosso Deus Seu Santo monte\n" +
                        "Alegria de toda terra\n" +
                        "\n" +
                        "Grande é o Senhor em quem nós temos a vitória\n" +
                        "E que nos ajuda contra o inimigo\n" +
                        "Por isso diante Dele nos prostramos\n" +
                        "\n" +
                        "Queremos o Teu nome engrandecer\n" +
                        "E agradecer-Te por Tua obra em nossas vidas\n" +
                        "Confiamos em Teu infinito amor\n" +
                        "Pois só Tu és o Deus eterno\n" +
                        "Sobre toda terra e céu",

                "Praza-te, oh Deus, em me livrar\n" +
                        "Sê pressuroso em me acudir\n" +
                        "Tenha vergonha e confusão\n" +
                        "Quem minha vida quer tirar\n" +
                        "Envergonhado, volte atrás\n" +
                        "Quem se compraz no meu sofrer\n" +
                        "Vergonha os faça recuar\n" +
                        "Pois eles zombam do meu mal\n" +
                        "\n" +
                        "Quem te procura, oh Senhor,\n" +
                        "Folgue e jubile sempre em Ti\n" +
                        "“Magnificado seja Deus”\n" +
                        "Diga quem ama a salvação\n" +
                        "Necessitado e pobre sou\n" +
                        "Oh Deus te apressa em me valer\n" +
                        "Amparo meu, Libertador\n" +
                        "Não te detenhas, oh Senhor",

                "O que ouvimos e aprendemos\n" +
                        "O que nos contaram nossos pais\n" +
                        "Não encobriremos aos nossos filhos\n" +
                        "Contaremos às vindouras gerações\n" +
                        "Os louvores do Senhor, o Seu poder\n" +
                        "E as maravilhas que fez\n" +
                        "\n" +
                        "Como nos tirou das trevas para a luz\n" +
                        "E nos deu preciosas bençãos por Jesus\n" +
                        "Deu sentido a nossas vidas, e paz\n" +
                        "\n" +
                        "O que ouvimos e aprendemos\n" +
                        "O que nos contaram nossos pais\n" +
                        "Não encobriremos aos nossos filhos\n" +
                        "Contaremos às vindouras gerações\n" +
                        "Os louvores do Senhor, o Seu poder\n" +
                        "E as maravilhas que fez\n" +
                        "\n" +
                        "Como Seu amor por nós é tão real\n" +
                        "Carinhoso é Seu cuidado paternal\n" +
                        "Pois sustenta nossa vida em paz\n" +
                        "\n" +
                        "O que ouvimos e aprendemos\n" +
                        "O que nos contaram nossos pais\n" +
                        "Não encobriremos aos nossos filhos\n" +
                        "Contaremos às vindouras gerações\n" +
                        "Os louvores do Senhor, o Seu poder\n" +
                        "E as maravilhas que fez",

                "Quão amáveis são os teus tabernáculos\n" +
                        "Senhor dos exércitos\n" +
                        "A minha alma suspira e desfalece Pelos teus átrios\n" +
                        "\n" +
                        "[Coro]\n" +
                        "O pardal encontrou casa\n" +
                        "E a andorinha, ninho para si\n" +
                        "Eu encontrei teus altares, Senhor\n" +
                        "Rei meu e Deus meu\n" +
                        "Eu encontrei teus altares, Senhor\n" +
                        "Rei meu e Deus meu\n" +
                        "\n" +
                        "Bem aventurados aqueles que habitam\n" +
                        "Em Tua casa\n" +
                        "Pois um só dia, Senhor nos Teus átrios\n" +
                        "Vale mais que mil\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Pois o Senhor é sol e escudo Dá graça e glória\n" +
                        "Não negará bem algum aos que vivem\n" +
                        "Corretamente\n" +
                        "\n" +
                        "[Coro]",

                "Cantai ao Senhor um cântico novo\n" +
                        "Cantai ao Senhor todas as terras\n" +
                        "Cantai ao Senhor bendizei o seu nome\n" +
                        "Proclamai a sua Salvação\n" +
                        "\n" +
                        "Anunciai entre as nações a sua glória\n" +
                        "E entre todos os povos as suas maravilhas\n" +
                        "Porque grande é o Senhor\n" +
                        "E mui digno de ser louvado\n" +
                        "Mais temível do que falsos deuses\n" +
                        "\n" +
                        "Glória e majestade estão diante dele\n" +
                        "Força e formosura no seu santuário (2x)",

                "Meu refúgio está em Deus\n" +
                        "Como podes me dizer\n" +
                        "“Qual ave foge ao monte seu\n" +
                        "Assim fujas também?\n" +
                        "Pois eis que os ímpios vão\n" +
                        "Têm já pronto o arco à mão\n" +
                        "Para às ocultas disparar\n" +
                        "Nos justos de coração\n" +
                        "\n" +
                        "Quando há destruição\n" +
                        "Fundamentos já não são\n" +
                        "Que pode o justo fazer então\n" +
                        "Se nessa vil condição?”\n" +
                        "No templo está o Senhor\n" +
                        "Tem nos céus o trono seu\n" +
                        "Seus olhos sondam com atenção\n" +
                        "Os filhos dos homens vê\n" +
                        "\n" +
                        "E ao justo aprova Deus\n" +
                        "Mas odeia o homem mau\n" +
                        "E aquele que violência faz\n" +
                        "Deus o abomina já\n" +
                        "Javé fará chover\n" +
                        "Fogo, enxofre sobre os maus\n" +
                        "E vento abrasador será\n" +
                        "A taça que lhes dará\n" +
                        "\n" +
                        "Pois justo é o Senhor\n" +
                        "Ele ama a retidão\n" +
                        "E cada um que justo for\n" +
                        "A face lhe verá\n" +
                        "Pois justo é o Senhor\n" +
                        "Ele ama a retidão\n" +
                        "E cada um que justo for\n" +
                        "A face lhe verá",

                "Rendei graças ao Senhor porque Ele é bom\n" +
                        "Rendei graças ao Senhor porque Ele é bom\n" +
                        "Porque a sua misericórdia dura para sempre\n" +
                        "Rendei graças ao Senhor\n" +
                        "Porque a sua misericórdia dura para sempre\n" +
                        "Rendei graças ao Senhor\n" +
                        "\n" +
                        "Rendei graças ao Deus dos deuses porque Ele é bom\n" +
                        "Rendei graças ao Deus dos deuses porque Ele é bom\n" +
                        "Porque a sua misericórdia dura para sempre\n" +
                        "Rendei graças ao Senhor\n" +
                        "Porque a sua misericórdia dura para sempre\n" +
                        "Rendei graças ao Senhor",

                "Não a nós Senhor\n" +
                        "Não a nós Senhor\n" +
                        "Mas ao Teu nome dá glória\n" +
                        "Por amor da Tua misericórdia\n" +
                        "E da Tua fidelidade\n" +
                        "\n" +
                        "Por que perguntam as nações:\n" +
                        "Onde está o vosso Deus?\n" +
                        "No céu está o nosso Deus\n" +
                        "E tudo faz como lhe agrada\n" +
                        "\n" +
                        "Não a nós Senhor\n" +
                        "Não a nós Senhor\n" +
                        "Mas ao Teu nome dá glória\n" +
                        "Por amor da Tua misericórdia\n" +
                        "E da Tua fidelidade\n" +
                        "\n" +
                        "Por que confiam as nações\n" +
                        "Em ouro, prata e riquezas?\n" +
                        "E se afastam do Senhor\n" +
                        "Que é fonte de todas as bênçãos?\n" +
                        "\n" +
                        "Não a nós Senhor\n" +
                        "Não a nós Senhor\n" +
                        "Mas ao Teu nome dá glória\n" +
                        "Por amor da Tua misericórdia\n" +
                        "E da Tua fidelidade",

                "Ao Senhor Deus rendei louvor\n" +
                        "Todos os povos, adorai\n" +
                        "Daí louvores, oh gentios!\n" +
                        "Porque mui grande é o Seu favor\n" +
                        "Sua misericórdia em nós\n" +
                        "Do Senhor fidelidade\n" +
                        "Para sempre permanece! Aleluia!\n" +
                        "(2x)",

                "Buscai primeiro o Reino de Deus\n" +
                        "E a Sua Justiça\n" +
                        "E as demais coisas vos serão acrescentadas\n" +
                        "Aleluia\n" +
                        "\n" +
                        "Aleluia, Aleluia\n" +
                        "Aleluia, Aleluia\n" +
                        "Aleluia\n" +
                        "\n" +
                        "Não só de pão o homem viverá\n" +
                        "Mas de toda a Palavra\n" +
                        "Que procede da boca de Deus\n" +
                        "Aleluia, Aleluia\n" +
                        "\n" +
                        "Aleluia, Aleluia\n" +
                        "Aleluia, Aleluia\n" +
                        "Aleluia",

                "Como a corça suspira no rio beber\n" +
                        "A minh’alma suspira por ti oh meu Deus\n" +
                        "Do Deus vivo, minh’alma, tem sede de Deus\n" +
                        "Quando perante Ele estarei?\n" +
                        "Dia e noite meu choro tem sido o meu pão\n" +
                        "Pois a mim dizem sempre: “Teu Deus, onde está?”\n" +
                        "Destas coisas me lembro e minh’alma em mim\n" +
                        "Se derrama de como eu passava com o povo\n" +
                        "Conduzindo-o à Casa de Deus\n" +
                        "\n" +
                        "Entre gritos alegres e o povo a louvar\n" +
                        "Caminhava em festa com a multidão\n" +
                        "Por que estás abatida, oh minh’alma, por quê?\n" +
                        "Dentro em mim perturbada estás?\n" +
                        "Pois ainda ao meu Deus, meu auxílio, louvor\n" +
                        "Hei de dar, oh minh’alma, que espera em Deus\n" +
                        "Sinto dentro de mim abatido o meu ser\n" +
                        "E no Monte Hermon de ti lembro\n" +
                        "Nas terras do Jordão, no outeiro, em Mizar\n" +
                        "\n" +
                        "Um abismo está outro abismo a chamar\n" +
                        "Ao fragor das tuas águas em queda a correr\n" +
                        "Tuas ondas e vagas passaram, Senhor\n" +
                        "Todas elas cobriram meu ser\n" +
                        "Mas de dia o Senhor concedeu-me mercê\n" +
                        "E de noite comigo está seu louvor\n" +
                        "Uma prece ao Senhor da minha vida orarei\n" +
                        "Digo a Deus: “Minha Rocha, por que te olvidaste\n" +
                        "E me tens esquecido oh Senhor?”\n" +
                        "\n" +
                        "Por que hei de andar, em lamento e opressão\n" +
                        "Sob a mão de inimigos e os ossos ao pó?\n" +
                        "Adversários me insultam, repetem sem fim\n" +
                        "Dizem: “Deus, o teu Deus, onde está?”\n" +
                        "Por que estás oh minh’alma abatida em mim?\n" +
                        "Perturbada, por que, dentro em meu coração?\n" +
                        "Inda hei de louvores a Deus dirigir\n" +
                        "Esperança em Deus, oh minh’alma mantém, pois\n" +
                        "Meu auxílio e meu Deus é o Senhor",

                "Aquele que tem os meus mandamentos e os guarda\n" +
                        "Esse é o que me ama (2X)\n" +
                        "\n" +
                        "E aquele que me ama será amado por me Pai\n" +
                        "E eu também o amarei e me manifestarei a ele",

                "Quem nos separará do amor de Cristo?\n" +
                        "Será tribulação, angústia ou perseguição\n" +
                        "Fome ou nudez, perigo ou espada? (2X)\n" +
                        "\n" +
                        "Porque estou bem certo\n" +
                        "De que nem morte nem vida \n" +
                        "Nem anjos nem principados\n" +
                        "Nem coisas do presente, nem do porvir\n" +
                        "Nem poderes, nem alturas\n" +
                        "Nem profundidade\n" +
                        "Nem qualquer outra criatura\n" +
                        "Poderá nos separar do amor de Deus\n" +
                        "Que está em Jesus Cristo\n" +
                        "Nosso Senhor\n" +
                        "Que está em Jesus Cristo\n" +
                        "\n" +
                        "Nada, nada poderá nos separar\n" +
                        "Nada, nada poderá nos separar\n" +
                        "Do amor de Deus, Que está em Jesus Cristo\n" +
                        "Nosso Senhor\n" +
                        "Que está em Jesus Cristo",

                "Porque o fim da lei é Cristo\n" +
                        "Pra justiça de todo que crê\n" +
                        "A justiça que é pela fé\n" +
                        "No filho de Deus\n" +
                        "A quem Deus ressuscitou\n" +
                        "Para nossa justificação\n" +
                        "\n" +
                        "Aleluia\n" +
                        "Grande salvação\n" +
                        "Aleluia\n" +
                        "Grande salvação\n" +
                        "Aleluia\n" +
                        "Grande salvação",

                "Oh profundidade da riqueza\n" +
                        "E da sabedoria e conhecimento de Deus\n" +
                        "Quão insondáveis seus juízos\n" +
                        "Inescrutáveis seus caminhos\n" +
                        "Quem conheceu a mente do nosso Senhor?\n" +
                        "\n" +
                        "Quem primeiro deu a Ele e depois recebeu?\n" +
                        "Porque Dele, por Ele, pra Ele são todas as coisas\n" +
                        "\n" +
                        "Quem primeiro deu a Ele e depois recebeu?\n" +
                        "Porque Dele, por Ele, pra Ele são todas as coisas\n" +
                        "\n" +
                        "Glória sejam dadas, pois a Ele eternamente. Amém!\n" +
                        "Glórias sejam dadas, pois a ele eternamente. Amém!",

                "Aquele que foi manifestado na carne\n" +
                        "Foi justificado em Espírito\n" +
                        "Contemplado por anjos\n" +
                        "Pregado entre os gentios\n" +
                        "Crido no mundo, recebido na glória\n" +
                        "\n" +
                        "Recebido na glória\n" +
                        "Na glória! Na glória! Na glória!\n" +
                        "Recebido na glória!\n" +
                        "\n" +
                        "Aquele que foi manifestado na carne\n" +
                        "Foi justificado em Espírito\n" +
                        "Contemplado por anjos\n" +
                        "Pregado entre os gentios\n" +
                        "Crido no mundo, recebido na glória\n" +
                        "\n" +
                        "Recebido na glória\n" +
                        "Na glória! Na glória! Na glória!\n" +
                        "Recebido na glória!",

                "Se confessarmos os nossos pecados\n" +
                        "Ele é fiel e justo\n" +
                        "Para nos perdoar os pecados\n" +
                        "E nos purificar\n" +
                        "De toda injustiça\n" +
                        "(2X)",

                "Ao Deus que nos guarda de tropeçar\n" +
                        "Para nos apresentar puros\n" +
                        "Diante da sua glória\n" +
                        "(2X)\n" +
                        "\n" +
                        "Ao único Deus, salvador\n" +
                        "Por meio de Cristo, o Senhor\n" +
                        "\n" +
                        "Majestade e glória Poder e reino\n" +
                        "Antes e agora\n" +
                        "E para todo o sempre\n" +
                        "(2X)",

                "Ao que está sentado\n" +
                        "No Trono e ao Cordeiro Seja o louvor\n" +
                        "E a honra, e a glória\n" +
                        "E o domínio\n" +
                        "Pelos séculos dos séculos Amém.\n" +
                        "(2X)",

                "Grandes são as tuas obras\n" +
                        "SENHOR, Todo-poderoso\n" +
                        "Justos e verdadeiros são os seus caminhos\n" +
                        "\n" +
                        "Oh Rei das nações quem não temerá?\n" +
                        "Quem não glorificará teu nome?\n" +
                        "Oh Rei das nações quem não te louvará?\n" +
                        "Pois só Teu nome é Santo\n" +
                        "\n" +
                        "Todas as nações virão\n" +
                        "E adorarão diante de ti\n" +
                        "Pois os teus atos de justiça\n" +
                        "Se fizeram manifestos\n" +
                        "\n" +
                        "Oh Rei das nações quem não temerá?\n" +
                        "Quem não glorificará teu nome?\n" +
                        "Oh Rei das nações quem não te louvará?\n" +
                        "Pois só Teu nome é Santo",

                "Nas margens lá dos rios da babilônia nos assentamos\n" +
                        "Lembrando de Sião, nós choramos, nós choramos\n" +
                        "Lá nos salgueiros nós penduramos todas as nossas harpas\n" +
                        "Pois nossos opressores a nós pediam canções alegres\n" +
                        "\n" +
                        "De Sião, pois, queriam ouvir os cantos\n" +
                        "Mas em terra de estranhos era impossível\n" +
                        "Que minha mão direita resseque toda\n" +
                        "Se de Jerusalém eu vier esquecer, se de Jerusalém eu vier esquecer\n" +
                        "\n" +
                        "Se eu não lembrar de ti que minha língua ao meu paladar se apegue\n" +
                        "Se eu a Jerusalém não preferir ao regozijo\n" +
                        "Dos filhos de Edon lembra-te Senhor, para seres contra\n" +
                        "Pois de Sião diziam até as bases arrasai-a\n" +
                        "\n" +
                        "Hás de ser, Babilônia, aniquilada\n" +
                        "Quem te der, pois, o pago será bendito\n" +
                        "Do mal que nos fizeste, sim grande mal\n" +
                        "Feliz quem aos teus filhos pegar, prendê-los\n" +
                        "Para esmagá-los todos contra os rochedos",

                "Maravilhosa graça! Maior que o meu pecar\n" +
                        "Como poder contá-la? Como hei de começar?\n" +
                        "Pois alivia a minha alma e vivo em toda calma\n" +
                        "Pela maravilhosa graça de Jesus\n" +
                        "\n" +
                        "[Coro]\n" +
                        "Graça quão maravilhosa, graça de Jesus\n" +
                        "Alta como o firmamento, alta e é sem fim\n" +
                        "É maravilhosa, é tão grandiosa\n" +
                        "É suficiente para mim\n" +
                        "É maior que a minha vida inútil\n" +
                        "É maior que o meu pecado vil\n" +
                        "O nome de Jesus engrandecei e glória lhe dai\n" +
                        "\n" +
                        "Maravilhosa graça! Traz vida perenal Por ela perdoado, vou a mansão real Ela abranda o meu fardo, gozo de Deus, o agrado\n" +
                        "Pela maravilhosa graça de Jesus\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Maravilhosa graça! Quão ricas bênçãos traz\n" +
                        "O seu poder transforma o pecador falaz\n" +
                        "Estou salvo com a verdade por toda eternidade\n" +
                        "Pela maravilhosa graça de Jesus\n" +
                        "\n" +
                        "[Coro]",

                "Cheguemo-nos, pois, com ousadia\n" +
                        "E entremos no Santo dos santos\n" +
                        "Pelo sangue de Jesus\n" +
                        "O novo caminho que nos consagrou\n" +
                        "Diante do trono da graça\n" +
                        "Com corações verdadeiros\n" +
                        "Em inteira certeza de fé\n" +
                        "Cantemos a vitória do Cordeiro\n" +
                        "\n" +
                        "Porque Ele é digno de receber\n" +
                        "O louvor, a glória e o poder\n" +
                        "É o Deus exaltado\n" +
                        "Pra sempre adorado\n" +
                        "Jesus, Senhor, o Eterno vencedor",

                "Aleluia! Salvação e glória!\n" +
                        "Honra e poder pertencem ao nosso Deus (2x)\n" +
                        "\n" +
                        "Canta, aleluia! vem dar-lhe glória\n" +
                        "Levantai o seu nome\n" +
                        "Jesus é o rei dos reis (2x)",

                "Quem vai morar, Senhor, no teu santo templo?\n" +
                        "Quem há de residir no teu monte, oh Deus?\n" +
                        "Quem vive em retidão, tem justo proceder\n" +
                        "Só a verdade diz no seu coração\n" +
                        "\n" +
                        "Não vive a difamar, não faz mal a outrem\n" +
                        "Ao seu vizinho não quer injuriar\n" +
                        "Despreza o homem vil, honra ao que teme a Deus\n" +
                        "Jura com perda, até, mas não volta atrás\n" +
                        "\n" +
                        "O seu dinheiro não cede com usura\n" +
                        "Suborno algum jamais pensa receber\n" +
                        "Para incriminar quem inocente é\n" +
                        "Quem assim proceder, não se abalará",

                "Por que se amotinam as nações\n" +
                        "Pensam os povos sempre em vaidade?\n" +
                        "Os reis da terra tomam posições\n" +
                        "E os governantes buscam unidade\n" +
                        "Contra o Senhor e contra o Seu Ungido\n" +
                        "Dizendo: ”Os laços seus vamos romper\n" +
                        "Suas algemas lançaremos fora\n" +
                        "Deles queremos nós nos desfazer”\n" +
                        "\n" +
                        "Porém aquele que nos céus está\n" +
                        "Põe-se a rir o Senhor zomba deles\n" +
                        "Na sua ira há de lhes falar\n" +
                        "No seu furor os deixará turbados:\n" +
                        "Constitui meu rei, o meu Ungido\n" +
                        "Sobre o meu santo monte de Sião\n" +
                        "Proclamarei do Senhor seu decreto:\n" +
                        "Disse: “És meu Filho, hoje te gerei”\n" +
                        "\n" +
                        "Pede a mim, e herdarás nações\n" +
                        "E os fins da terra como tua posse\n" +
                        "Com teu bastão de ferro as quebrarás\n" +
                        "Qual vaso do oleiro despedaçarás\n" +
                        "Agora pois oh reis sede prudentes\n" +
                        "Deixai-vos oh juízes exortar\n" +
                        "Prestai a Deus serviço com temor\n" +
                        "E alegrai-vos nele com tremor\n" +
                        "\n" +
                        "Beijai o Filho, Ungido do Senhor\n" +
                        "Para que sua ira não se acenda\n" +
                        "E no caminho ainda pereçais\n" +
                        "Quando em breve seu furor se levantar\n" +
                        "São todos nEle bem-aventurados\n" +
                        "Todo que nele se refugiar\n" +
                        "São todos nEle bem-aventurados\n" +
                        "Todo que nele se refugiar",

                "Só em Jesus confiarei,\n" +
                        "És minha força, luz, canção\n" +
                        "Pedra angular que me sustém\n" +
                        "Na tempestade ou sequidão\n" +
                        "Quão grande amor, profunda paz\n" +
                        "Em meio a dor em horas más\n" +
                        "Consolador és tudo em mim\n" +
                        "Firmado estou em teu amor\n" +
                        "\n" +
                        "Só em Jesus, que se encarnou\n" +
                        "Poder de Deus num frágil ser\n" +
                        "Foi desprezado pelos seus,\n" +
                        "Mas se agradou, por mim, morrer\n" +
                        "E lá na cruz, o próprio Deus\n" +
                        "A sua ira satisfez\n" +
                        "O meu pecado suportou\n" +
                        "Vivo na morte dele estou\n" +
                        "\n" +
                        "Foi sepultada a nossa luz\n" +
                        "Tragada pela escuridão\n" +
                        "Mas no terceiro dia, então\n" +
                        "Ressuscitou o meu Jesus\n" +
                        "Grande vitória conquistou\n" +
                        "Do vil pecado me livrou\n" +
                        "Então sou dele e ele é meu\n" +
                        "Pelo seu sangue que verteu\n" +
                        "\n" +
                        "Não há mais culpa e nem pavor\n" +
                        "Esse é o poder de Cristo em mim\n" +
                        "Jesus comanda o meu viver\n" +
                        "Desde o início até o fim\n" +
                        "Nenhuma força poderá\n" +
                        "De sua mão me arrancar\n" +
                        "Até com ele me encontrar\n" +
                        "No seu poder eu viverei",

                "Os céus proclamam sua glória\n" +
                        "E o firmamento anuncia\n" +
                        "Que tudo fez o Senhor\n" +
                        "Que tudo vem do Senhor\n" +
                        "\n" +
                        "O dia revela a outro dia\n" +
                        "A noite traz conhecimento\n" +
                        "Que tudo fez o Senhor \n" +
                        " tudo vem do Senhor\n" +
                        " \n" +
                        "[Coro]\n" +
                        "Cantarei ao Senhor\n" +
                        "Reinará para sempre\n" +
                        "Bendirei ao Senhor\n" +
                        "Que é fiel\n" +
                        "\n" +
                        "A lei que tu nos revelaste\n" +
                        "Perfeita e restaura a alma\n" +
                        "Pois justo é o Senhor\n" +
                        "E Santo é o Senhor\n" +
                        "\n" +
                        "As palavras dos meus lábios\n" +
                        "E o meditar do coração\n" +
                        "Agradem a ti Senhor\n" +
                        "Agradem a ti Senhor\n" +
                        "\n" +
                        "[Coro]",

                "Eis o cordeiro assentado em seu trono\n" +
                        "Que coisas novas nos acrescentou\n" +
                        "São tuas palavras a fonte de vida\n" +
                        "Palavra fiel do Senhor\n" +
                        "\n" +
                        "Ele é quem julga os povos da terra\n" +
                        "O alfa e o ômega, princípio e o fim\n" +
                        "Ele é a fonte que jorra água viva\n" +
                        "Ele é o Senhor nosso Deus\n" +
                        "\n" +
                        "Quanto aos covardes e descrentes também\n" +
                        "Todo o impuro e assassino cruel\n" +
                        "Serão lançados no lago de fogo\n" +
                        "E condenados estão\n" +
                        "\n" +
                        "Mas todo aquele que a ti confessar\n" +
                        "Darás da fonte que jorra da cruz\n" +
                        "Todo o teu povo diante de ti\n" +
                        "Teu nome, então, louvarão\n" +
                        "\n" +
                        "Aleluia! Santo Cordeiro, o Salvador\n" +
                        "Aleluia! O Reis dos reis, nosso Deus",

                "Eis o Cordeiro que por nós sofreu e morreu\n" +
                        "Nossos pecados são perdoados em Jesus\n" +
                        "Se pela fé o receber\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "E então a compartilhar\n" +
                        "Deste pão que a vida traz\n" +
                        "E o Seu sangue, nossa redenção\n" +
                        "Ele é o Cordeiro de Deus\n" +
                        "\n" +
                        "Eis o Cordeiro nosso redentor, o SENHOR\n" +
                        "E nos lembramos a sua morte fez nos reviver\n" +
                        "Pela cruz do Salvador\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Eis o Cordeiro Santificador, o SENHOR\n" +
                        "Purificados, fomos lavados pelo sangue de Jesus\n" +
                        "O Redentor\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Eis o Cordeiro, Soberano Rei, o SENHOR\n" +
                        "E esperamos a vida eterna triunfar com o SENHOR\n" +
                        "O Rei Jesus\n" +
                        "\n" +
                        "[Coro]",

                "Esperei confiantemente no Senhor\n" +
                        "E Ele se inclinou para mim\n" +
                        "E me ouviu quando clamei por socorro\n" +
                        "E me ouviu quando clamei por socorro\n" +
                        "\n" +
                        "[Coro]\n" +
                        "E me pôs nos lábios uma nova canção\n" +
                        "Um hino de louvor ao nosso Deus\n" +
                        "Muitos verão essas coisas com temor\n" +
                        "E confiarão no Senhor\n" +
                        "\n" +
                        "Tirou-me de um poço de lama e perdição\n" +
                        "Colocou-me os pés sobre a rocha\n" +
                        "E me firmou os passos, e me firmou os passos\n" +
                        "\n" +
                        "[Coro]",

                "Em tuas mãos minha vida está\n" +
                        "Sei o quão pobre eu sou\n" +
                        "Pois só em ti eu irei confiar\n" +
                        "O teu socorro, tu podes me dar\n" +
                        "\n" +
                        "Já não há homens que sejam fiéis\n" +
                        "A tua verdade, cumprir\n" +
                        "Pois com a língua professam mentiras\n" +
                        "E do teu nome, injúrias oh Senhor\n" +
                        "\n" +
                        "Necessitado e pobre que estou\n" +
                        "Por ti, oh Deus, suspirar\n" +
                        "Pois todo aquele que a ti confessar\n" +
                        "A tua graça irão alcançar\n" +
                        "\n" +
                        "Também tu julgas o meu coração\n" +
                        "De ti não posso esconder\n" +
                        "Meus pensamentos, tu podes sondar\n" +
                        "Com tua justiça, oh vens visitar\n" +
                        "\n" +
                        "Tua Palavra triunfa Senhor\n" +
                        "Sobre a Terra e os céus\n" +
                        "E os teus filhos também livrarás\n" +
                        "Na Tua verdade nos faz repousar. Amém",

                "Minha oração atende oh Deus\n" +
                        "Ouve oh Pai, meu suplicar\n" +
                        "Dos fins da terra clamo a Ti\n" +
                        "Com abatido coração\n" +
                        "Leva-me à Rocha, oh Senhor\n" +
                        "Que é bem mais alta do que eu\n" +
                        "Pois torre forte és para mim\n" +
                        "Refúgio contra os homens maus\n" +
                        "\n" +
                        "No templo sempre assista eu\n" +
                        "Sob tuas asas, firme estou\n" +
                        "No esconderijo protetor\n" +
                        "Pois escutaste os votos meus\n" +
                        "Me deste a herança dos que têm\n" +
                        "Temor ao nome Teu, Senhor\n" +
                        "E longo tempo dás ao Rei\n" +
                        "Seus anos duram gerações\n" +
                        "\n" +
                        "Que permaneça diante de Deus\n" +
                        "Para sempre o nosso rei\n" +
                        "Tua verdade e teu favor\n" +
                        "Seu reino possam preservar\n" +
                        "Assim Teu nome louvarei\n" +
                        "Com Salmos sempre cantarei\n" +
                        "E dia-a-dia cumprirei\n" +
                        "Os votos feitos ao Senhor",

                "Senhor tu me sondas, sabes de mim\n" +
                        "Conheces meu sentar, meu levantar\n" +
                        "E de longe sondas meu pensar\n" +
                        "Estudas meu andar e o meu deitar\n" +
                        "\n" +
                        "Sabes meus caminhos, meu falar\n" +
                        "Antes da palavra pronunciar\n" +
                        "Tu me cercas por completo e pões\n" +
                        "Sobre mim a tua mão, Senhor\n" +
                        "\n" +
                        "Tal conhecimento é demais\n" +
                        "Elevado a mim\n" +
                        "É maravilhoso e além\n" +
                        "Do entendimento\n" +
                        "\n" +
                        "Como me ausentar da face de Deus\n" +
                        "Ou do teu Santo Espírito fugir?\n" +
                        "Se subir aos céus tu lá estás\n" +
                        "Se me deitar no abismo estás também\n" +
                        "\n" +
                        "Se eu tomar as asas da manhã\n" +
                        "Nos confins dos mares me deter\n" +
                        "Inda lá tua mão me guiará\n" +
                        "Tua destra me sustentará\n" +
                        "\n" +
                        "Se eu disser que as trevas então\n" +
                        "Hão de me encobrir\n" +
                        "Ao redor de mim toda luz\n" +
                        "Há de ser escura\n" +
                        "\n" +
                        "Nem as trevas são escuras a ti\n" +
                        "Trevas e luz tu julgas como iguais\n" +
                        "Pois formaste o meu interior\n" +
                        "Tu me teceste dentro em minha mãe\n" +
                        "\n" +
                        "Com assombro me formaste então\n" +
                        "Graças renderei a ti, Senhor\n" +
                        "Tuas obras admiráveis são\n" +
                        "E minh’alma sabe muito bem\n" +
                        "\n" +
                        "E os meus ossos viste, Senhor\n" +
                        "Quando oculto fui\n" +
                        "Feito, entretecido tal qual\n" +
                        "Como em profundezas\n" +
                        "\n" +
                        "Tu me viste informe ainda, Senhor\n" +
                        "E no teu livro escrito meu viver\n" +
                        "Tu determinaste os dias meus\n" +
                        "Sem que houvesse pelo menos um\n" +
                        "\n" +
                        "Oh que preciosos para mim\n" +
                        "São teus pensamentos, oh Senhor\n" +
                        "Como é grande a soma! Se contar\n" +
                        "Como grãos de areia não têm fim\n" +
                        "\n" +
                        "Oh que desses cabo, Senhor\n" +
                        "Do perverso e mau\n" +
                        "Apartai-vos todos de mim\n" +
                        "Homens sanguinários\n" +
                        "\n" +
                        "Eles contra ti rebeldes estão\n" +
                        "Falam malícia, inimigos teus\n" +
                        "Não odeio eu quem odeia a ti?\n" +
                        "Não abomino os que são contra ti?\n" +
                        "\n" +
                        "Ódio consumado tenho sim\n" +
                        "São, de fato, inimigos meus\n" +
                        "Sonda-me, oh Deus, meu coração\n" +
                        "Prova-me, conhece o meu pensar\n" +
                        "\n" +
                        "Vê se há em mim, oh Senhor\n" +
                        "Um caminho mau\n" +
                        "Dá-me direção, oh meu Deus\n" +
                        "No caminho eterno",

                "Senhor é força e salvação\n" +
                        "Refúgio na tribulação\n" +
                        "Os meus passos firmará\n" +
                        "Pela mão me guiará, oh Senhor\n" +
                        "\n" +
                        "Justo e santo é o Senhor\n" +
                        "O ímpio perecerá\n" +
                        "Como a relva murchará\n" +
                        "Seu caminho findará, oh Senhor\n" +
                        "\n" +
                        "[Coro]\n" +
                        "Somente em ti, Senhor Em ti confiarei\n" +
                        "Espero em ti, Senhor\n" +
                        "Em ti descansarei\n" +
                        "Não me desamparará\n" +
                        "Nem ao mal me entregará\n" +
                        "Jesus\n" +
                        "\n" +
                        "Em ti eu me alegrarei\n" +
                        "Louvores eu te renderei\n" +
                        "Como a luz sempre a brilhar\n" +
                        "Tua justiça triunfará, oh Senhor\n" +
                        "\n" +
                        "[Coro]",

                "Bendize ao Senhor, oh minh’alma e tudo que existe em mim, bendiga\n" +
                        "Pois Seu nome é santo, bendize oh minh’alma ao Senhor\n" +
                        "Dos Seus benefícios não te esqueças de nem um só\n" +
                        "É Ele quem perdoa todas as tuas mais vis transgressões\n" +
                        "\n" +
                        "Quem sara de todas as tuas doenças, tua vida da cova salva\n" +
                        "E a tua cabeça coroa de graça e amor\n" +
                        "Quem tua velhice cumula de bens a fartar\n" +
                        "De sorte que tua mocidade como águia se renovará\n" +
                        "\n" +
                        "Justiça o Senhor executa e julga a todos os oprimidos\n" +
                        "Ao servo Moisés, seus caminhos, Deus manifestou\n" +
                        "Seus feitos notáveis aos israelitas mostrou\n" +
                        "Gracioso é Deus, paciente, benigno e tem compaixão\n" +
                        "\n" +
                        "Pra sempre Sua ira o Senhor não conserva, nem censura para sempre\n" +
                        "Não tem nos tratado conforme o nosso transgredir\n" +
                        "Nem nos retribui, pois, consoante requer nosso mal\n" +
                        "Deus ama ao que teme, tal qual a terra se alteia o céu\n" +
                        "\n" +
                        "E quanto o oriente e o ocidente se distam, assim, Deus, de nós\n" +
                        "Afasta os nossos pecados, tal pai que do filho tem dó\n" +
                        "Assim, dos que O temem, demonstra o Senhor compaixão\n" +
                        "Pois Deus sabe a nossa estrutura, conhece que nós somos pó\n" +
                        "\n" +
                        "Os dias do homem comparam-se à relva, assim como a flor do campo\n" +
                        "O homem floresce, mas desaparece também\n" +
                        "Mas murcha ao vento que nela soprando está\n" +
                        "Daí em diante, não mais se conhece qual é o seu lugar\n" +
                        "\n" +
                        "Desde eternidade à eternidade, a misericórdia segue\n" +
                        "A todos que O temem, justiça sobre as gerações\n" +
                        "A todos que guardam o pacto firmado por Deus\n" +
                        "E para os que lembram dos Seus mandamentos e os cumprem também\n" +
                        "\n" +
                        "Nos céus, Deus estabeleceu o Seu trono, Seu reino domina tudo\n" +
                        "E todas as hostes de anjos a Deus bendizei\n" +
                        "Grandiosos em força, que Sua Palavra cumpris\n" +
                        "E às ordens de Deus, todas elas, à risca, sim, executais\n" +
                        "\n" +
                        "E vós, os exércitos Seus, bendizei ao Senhor, vós, os Seus ministros\n" +
                        "Que Sua vontade fazeis, bendizei ao Senhor\n" +
                        "Vós, todas as obras, em todo lugar bendizei\n" +
                        "E em todo domínio de Deus, sim, bendize oh minh’alma ao Senhor",

                "Alegrei-me quando me disseram: Vamos à casa de Deus\n" +
                        "Nossos pés pararam junto às portas, teus portais, Jerusalém\n" +
                        "Construída, bem compacta, onde as tribos vão subir\n" +
                        "Pois convém a Israel\n" +
                        "\n" +
                        "Para ao santo nome do Senhor render sua gratidão\n" +
                        "Lá estão os tronos de justiça, os da casa de Davi\n" +
                        "Que prospere quem te ama, pela sua paz orai\n" +
                        "Por Jerusalém orai\n" +
                        "\n" +
                        "Reine paz entre os teus muros, nos palácios, ricos bens\n" +
                        "Por amor dos meus irmãos, por amor de amigos meus\n" +
                        "“Haja paz em ti”, eu peço, pela casa do Senhor\n" +
                        "Buscarei sempre o teu bem",

                "Refúgio e fortaleza é Deus, presente em socorrer\n" +
                        "Nas horas de tribulação não temos que temer\n" +
                        "Ainda que a terra toda venha a transtornar\n" +
                        "Ou que os montes se abalem no seio do mar\n" +
                        "\n" +
                        "Ainda que as águas venham a tumultuar\n" +
                        "Também os montes estremeçam com fúria total\n" +
                        "Um rio a cidade do Senhor vem alegrar\n" +
                        "O santuário das moradas do mais alto Ser\n" +
                        "\n" +
                        "E no seu meio Deus está, jamais se abalará\n" +
                        "Ajuda, pois, Deus lhe trará desde o amanhecer\n" +
                        "Os reinos podem se abalar nações, também, bramar\n" +
                        "A sua voz Deus levantou e a terra dissolveu\n" +
                        "\n" +
                        "O Senhor dos exércitos está conosco aqui\n" +
                        "Refúgio nosso Ele é, o Deus de lsrael\n" +
                        "Oh vinde contemplai as obras do Senhor Javé:\n" +
                        "Que assolações efetuou na terra o nosso Deus\n" +
                        "\n" +
                        "Põe termo à guerra até os confins do mundo o nosso Deus\n" +
                        "O arco Ele quebra, e a lança despedaçará\n" +
                        "Os carros todos Deus fará no fogo incendiar\n" +
                        "Põe termo à guerra até os confins do mundo o nosso Deus\n" +
                        "\n" +
                        "Aquietai-vos e sabei que Eu sou o vosso Deus\n" +
                        "Sou exaltado entre as nações na terra, grande eu sou\n" +
                        "O Senhor dos exércitos está conosco aqui\n" +
                        "Refúgio nosso Ele é, o Deus de lsrael",

                "Me achego a ti Soberano Senhor\n" +
                        "Perdido estou, mas me entrego enfim\n" +
                        "Derramaste teu sangue por mim na cruz\n" +
                        "Oh Cordeiro de Deus me achego a Ti\n" +
                        "\n" +
                        "[Coro]\n" +
                        "Quebrantado e ferido, abatido e condenado\n" +
                        "Pelo sangue do Cordeiro, fui em Cristo justificado\n" +
                        "Restaurado, transformado, recebido em teu amor\n" +
                        "Eu te louvo, meu Redentor, te louvo, tal como estou\n" +
                        "\n" +
                        "Me achego a Ti assim como estou\n" +
                        "Não demore oh Deus a me socorrer\n" +
                        "E livrar-me, então, desta escuridão\n" +
                        "Oh Cordeiro de Deus me achego a Ti\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Me achego a Ti assim como estou\n" +
                        "Pela cruz oh Deus livre agora eu sou\n" +
                        "Para tua glória comprado fui\n" +
                        "Oh Cordeiro de Deus me achego a Ti\n" +
                        "\n" +
                        "[Coro]",

                "Do Senhor é a terra e a sua plenitude\n" +
                        "O mundo e todos os habitantes seus\n" +
                        "Pois sobre os mares Ele a fundamentou\n" +
                        "E sobre as correntes, estabeleceu\n" +
                        "\n" +
                        "Quem, pois, subirá para o monte do Senhor\n" +
                        "Ou quem estará no Seu santo lugar?\n" +
                        "Aquele que é limpo de mãos e coração\n" +
                        "Não ama vaidade, enganoso não é\n" +
                        "\n" +
                        "Tal homem recebe a bênção do Senhor\n" +
                        "Justiça do Deus da sua salvação\n" +
                        "Tal é a linhagem daqueles que o buscam\n" +
                        "Que buscam a face do Deus de Jacó\n" +
                        "\n" +
                        "Erguei, já, oh portas as vossas cabeças\n" +
                        "Portais eternais, levantai-vos ao Rei\n" +
                        "A fim de que entre ali o Rei da glória\n" +
                        "Portais eternais, levantai-vos ao Rei\n" +
                        "\n" +
                        "Quem é o Rei da glória, este Rei tão glorioso?\n" +
                        "Senhor das batalhas, que é forte em poder\n" +
                        "Erguei, já, oh portas as vossas cabeças\n" +
                        "Portais eternais, levantai-vos ao Rei\n" +
                        "\n" +
                        "A fim de que entre ali o Rei da glória\n" +
                        "Portais eternais, levantai-vos ao Rei\n" +
                        "Quem é o Rei da glória, este Rei tão glorioso?\n" +
                        "Ele é o Rei da glória, das hostes Senhor",

                "Favoreceste a tua terra, Deus\n" +
                        "E restauraste as posses de Jacó\n" +
                        "Teu povo perdoaste do mal\n" +
                        "Cobrindo a multidão do seu pecar\n" +
                        "E contiveste todo o teu furor\n" +
                        "Oh Deus, Tu és a nossa salvação\n" +
                        "\n" +
                        "De sobre nós retira o Teu furor\n" +
                        "E vem Teu povo restabelecer\n" +
                        "O Teu furor se prolongará\n" +
                        "No povo e nas futuras gerações?\n" +
                        "Não voltarás a nos vivificar?\n" +
                        "E em Ti o povo venha se alegrar?\n" +
                        "\n" +
                        "Misericórdia mostra e vem salvar\n" +
                        "Escutarei, pois falarás de paz\n" +
                        "Jamais cometam insensatez\n" +
                        "A salvação dos justos perto está\n" +
                        "Sim, Tua salvação bem perto está\n" +
                        "Pra que Tua glória assista a terra, oh Deus\n" +
                        "\n" +
                        "Verdade e graça vieram se encontrar\n" +
                        "Beijaram-se a justiça e a paz\n" +
                        "Do céu justiça baixe o olhar\n" +
                        "Verdade, sim, da terra vem brotar\n" +
                        "E fruto bom da terra Deus dará\n" +
                        "Pegadas justas, sendas se farão\n",
                "[Coro]\n" +
                        "Minh’alma canta ao Senhor\n" +
                        "Canta ao Senhor\n" +
                        "E eu o louvarei\n" +
                        "Minha alma canta ao Senhor\n" +
                        "Ao Senhor\n" +
                        "E eu o louvarei\n" +
                        "\n" +
                        "Nasce o sol é um novo dia\n" +
                        "Um novo cântico em meu coração\n" +
                        "E seja o que for ou provação a me atingir\n" +
                        "Mesmo à noite, eu te louvarei\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Rico és em misericórdia\n" +
                        "Tua bondade inunda o meu coração\n" +
                        "Tu és minha força na tribulação, Senhor\n" +
                        "Dez mil razões para, então, cantar\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Se esgotam as minhas forças\n" +
                        "E abatido está o meu coração\n" +
                        "Tu és minha força e minha visão, Senhor\n" +
                        "Somente a Ti, então, irei cantar\n" +
                        "\n" +
                        "[Coro]",

                "Oh Deus, me guarda\n" +
                        "Em Tua morada\n" +
                        "Pois digo a Ti\n" +
                        "Tu és o meu Senhor\n" +
                        "\n" +
                        "És meu tesouro\n" +
                        "Em Ti confio, oh Deus\n" +
                        "Não há outro bem\n" +
                        "Além de Ti, Senhor\n" +
                        "\n" +
                        "Os fiéis na terra habitar\n" +
                        "É o Teu povo, sim guardarás\n" +
                        "Do inimigo os livrarás\n" +
                        "Oh Senhor, Tua vontade faz em mim\n" +
                        "\n" +
                        "Minha vida em tuas mãos\n" +
                        "Eu sei que sempre estará\n" +
                        "Que posso fazer?\n" +
                        "Sem Ti não posso viver\n" +
                        "\n" +
                        "Me aconselhas\n" +
                        "Noite e dia, Senhor\n" +
                        "Por Tua Palavra\n" +
                        "Conduz meu caminhar\n" +
                        "\n" +
                        "Pois da morte me livrarás\n" +
                        "Em Tua casa me faz morar\n" +
                        "Alegria sempre darás\n" +
                        "Oh Senhor, para sempre o louvarei",

                "Mesmo que aqui vier sofrer\n" +
                        "Não temerei a morte oh Senhor\n" +
                        "Mesmo que amanhã o mal vier\n" +
                        "Pois ao meu lado eu sei que estarás\n" +
                        "\n" +
                        "[Coro]\n" +
                        "Deus, Tu és meu Deus\n" +
                        "Somente em Ti confiarei, oh Deus\n" +
                        "Vem Senhor da paz\n" +
                        "Minh’alma, então, fortalecer\n" +
                        "E em Ti vou descansar\n" +
                        "\n" +
                        "Se a tentação me assediar\n" +
                        "Por mais sombria e escura\n" +
                        "Sim, seguro estou em Ti Senhor\n" +
                        "Pelo escudo que é a fé em Ti\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Mesmo que abatido eu possa estar\n" +
                        "Não me abandonarás, Senhor\n" +
                        "Os que esperam em Ti\n" +
                        "Aguardam aqui, na esperança de contigo estar\n" +
                        "\n" +
                        "[Coro]",

                "[Coro]\n" +
                        "Com a minha voz clamo ao Senhor\n" +
                        "Com a minha voz ao Senhor suplico\n" +
                        "Diante dele a queixar-me eu estou\n" +
                        "Diante dele exponho a minha aflição\n" +
                        "\n" +
                        "Quando aqui dentro de mim esmorece o meu Espírito\n" +
                        "Tu então conheces minha vereda\n" +
                        "Olha a mão direita e vê não há quem me conheça\n" +
                        "Não há ninguém onde me refugiar\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Oh, Senhor, a ti clamei, pois tu és o meu refugio\n" +
                        "E o meu tesouro entre os viventes\n" +
                        "Vem, atende o meu clamor, que estou muito abatido\n" +
                        "Livrar-me vem do forte tentador\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Tira-me desta prisão e assim louvarei teu nome\n" +
                        "Então os justos me cercarão\n" +
                        "Meu Senhor eu clamo a ti, oh vem livrar minh’alma\n" +
                        "E cantarei que me fizeste bem",

                "Aleluia, oh minh’alma, glorifica ao teu Senhor\n" +
                        "E durante a minha vida, cantarei em Seu louvor\n" +
                        "Não confieis em governantes, nem nos homens, pra salvar\n" +
                        "Seus projetos cessam todos, quando o espírito lhes sai\n" +
                        "\n" +
                        "Bem aventurado aquele cujo Deus é o de Jacó\n" +
                        "Que recebe seu auxílio, esperando em Deus Javé\n" +
                        "Ele fez os céus e a terra, fez o mar e tudo mais\n" +
                        "E fiel eternamente, o Senhor se manterá\n" +
                        "\n" +
                        "Faz justiça aos oprimidos, ao faminto dá o pão\n" +
                        "O Senhor liberta os presos, abatidos põe de pé\n" +
                        "O Senhor ao justo ama, faz o cego enxergar\n" +
                        "Sobre órfãos e viúvas, seu amparo Ele dá\n" +
                        "\n" +
                        "O Senhor ao forasteiro, lhe concede proteção\n" +
                        "Mas dos ímpios o caminho, o Senhor transtornará\n" +
                        "Para sempre o Senhor reina, oh Sião, teu Deus é Rei\n" +
                        "De uma geração à outra, reina Deus, aleluia",

                "Vem Senhor na minha angústia\n" +
                        "Livrar-me do caminho mau\n" +
                        "Dos perigos que me cercam\n" +
                        "Tu és meu refúgio oh Senhor\n" +
                        "\n" +
                        "[Coro]\n" +
                        "Pois a Ele eu clamarei\n" +
                        "E o Senhor me ouvirá\n" +
                        "Dia e noite Ele me guardará\n" +
                        "Soberano Redentor\n" +
                        "\n" +
                        "Volto os olhos para os montes\n" +
                        "O meu socorro onde está?\n" +
                        "O Senhor é o meu auxílio\n" +
                        "Que céus e terra criou\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Não desviarão os meus passos\n" +
                        "Pois Ele me guiará\n" +
                        "O Senhor é quem me guarda\n" +
                        "O protetor de Israel\n" +
                        "\n" +
                        "[Coro]",

                "Te exaltarei oh Rei e Deus meu\n" +
                        "Para sempre bendirei o teu nome\n" +
                        "Todos os dia proclamarei\n" +
                        "O Senhor nosso Deus é tão grande\n" +
                        "\n" +
                        "[Coro]\n" +
                        "Cantai ao redentor\n" +
                        "Poderoso e perfeito em suas obras\n" +
                        "E toda a criação anuncie em alta voz\n" +
                        "Ele é o Senhor\n" +
                        "\n" +
                        "Meditarei no teu glorioso esplendor\n" +
                        "E na tua majestade\n" +
                        "Proclamarei tuas obras, Senhor\n" +
                        "E direi grandes são os teus feitos\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Sua bondade e misericórdia\n" +
                        "Permeiam tuas obras na criação\n" +
                        "O teu domínio em todo universo\n" +
                        "Se faz revelado entre as nações\n" +
                        "\n" +
                        "[Coro]\n" +
                        "\n" +
                        "Santo e fiel em tua Palavra\n" +
                        "E em todas as obras de suas mãos\n" +
                        "Ele é quem salva aqueles que invocam\n" +
                        "E confessam teu nome em alta voz\n" +
                        "\n" +
                        "Te exaltarei Senhor\n" +
                        "Grande Deus e autor da nossa salvação\n" +
                        "Autor da criação e direi em alta voz\n" +
                        "Ele é o Senhor",

                "O Senhor é a minha rocha e o meu libertador\n" +
                        "Meu rochedo em quem refugio a força da minha salvação\n" +
                        "Na alegria ou provação te invocarei\n" +
                        "Tenho guardado os teus caminhos, oh grande Rei\n" +
                        "\n" +
                        "[Coro]\n" +
                        "Te amo oh Deus, meu salvador\n" +
                        "Minha esperança e minha força estão no Senhor\n" +
                        "Te exaltarei, meu Salvador\n" +
                        "O meu refúgio e proteção vêm do Senhor\n" +
                        "\n" +
                        "Livrou-me do forte inimigo, mais poderoso do que eu\n" +
                        "Ele me serviu de amparo, em tempos de tribulação\n" +
                        "Na alegria ou provação te invocarei\n" +
                        "Tenho guardado os teus caminhos, oh grande Rei\n" +
                        "\n" +
                        "[Coro]",

                "Oh Senhor, teu nome é\n" +
                        "Magnífico em toda a terra\n" +
                        "Expuseste na criação tua majestade\n" +
                        "Teu poder e força\n" +
                        "E tua glória enche a terra\n" +
                        "Digno tu és pra sempre\n" +
                        "\n" +
                        "Quando vejo os teus céus\n" +
                        "Que são obras dos teus dedos\n" +
                        "Que é o homem que dele lembres\n" +
                        "E o filho do homem para que o visites\n" +
                        "É a imagem e semelhança\n" +
                        "A expressão da tua glória",

                "Senhor, como aumentam contra mim\n" +
                        "Os opositores meus\n" +
                        "São muitos que proferem contra mim:\n" +
                        "“Nem Deus o salvará”\n" +
                        "\n" +
                        "Tu és minha glória, escudo meu\n" +
                        "Exaltas o servo teu\n" +
                        "Clamei com minha voz: responde-me\n" +
                        "Do santo monte Seu\n" +
                        "\n" +
                        "E pego no sono ao deitar\n" +
                        "Acordo, pois me susténs\n" +
                        "Não temo a multidão ao meu redor\n" +
                        "Que contra mim está\n" +
                        "\n" +
                        "Levanta-te oh Deus, vem me salvar\n" +
                        "Feriste inimigos meus\n" +
                        "Seus dentes e seus queixos quebrastes\n" +
                        "Ferindo-os de uma vez\n" +
                        "\n" +
                        "Ao Senhor Javé, o nosso Deus\n" +
                        "Pertence a salvação\n" +
                        "A bênção divinal esteja, pois\n" +
                        "No povo Teu, Senhor",

                "Meu refúgio está em Deus\n" +
                        "Como podes me dizer\n" +
                        "“Qual ave foge ao monte seu\n" +
                        "Assim fujas também\n" +
                        "Pois eis que os ímpios vão\n" +
                        "Têm já pronto o arco à mão\n" +
                        "Para às ocultas disparar\n" +
                        "Nos justos de coração\n" +
                        "\n" +
                        "Quando há destruição\n" +
                        "Fundamentos já não são\n" +
                        "Que pode o justo fazer então\n" +
                        "Se nesta vil condição?”\n" +
                        "No tempo está o Senhor\n" +
                        "Tem nos céus o trono seu\n" +
                        "Seus olhos sondam com atenção\n" +
                        "Os filhos dos homens vê\n" +
                        "\n" +
                        "E ao justo aprova Deus\n" +
                        "Mas odeia o homem mal\n" +
                        "E aquele que violência faz\n" +
                        "Deus o abomina já\n" +
                        "Javé fara chover\n" +
                        "Fogo, enxofre, sobre os maus\n" +
                        "E vento abrasador será\n" +
                        "A taça que lhes dará\n" +
                        "\n" +
                        "Pois justo é o Senhor\n" +
                        "Ele ama a retidão\n" +
                        "E cada um que justo for\n" +
                        "A face lhe verá\n" +
                        "Pois justo é o Senhor\n" +
                        "Ele ama a retidão\n" +
                        "E cada um que justo for\n" +
                        "A face lhe verá",

                "Fale, Ó Deus\n" +
                        "Venha dar a nós o alimento\n" +
                        "Tua Palavra\n" +
                        "Vem plantar tua verdade\n" +
                        "Em todo o meu ser, para sempre\n" +
                        "\n" +
                        "Seja Cristo a luz a brilhar em nós\n" +
                        "Com amor e fé seja o nosso viver\n" +
                        "Fale, Ó Deus\n" +
                        "A cumprir em nós teus propósitos\n" +
                        "Pra tua glória\n" +
                        "\n" +
                        "Vem, Senhor\n" +
                        "Nos ensina a te obedecer\n" +
                        "Com humildade\n" +
                        "Vem sondar nossos corações\n" +
                        "No esplendor da tua pureza\n" +
                        "\n" +
                        "Seja os nossos olhos a contemplar\n" +
                        "O amor de Cristo manifestar\n" +
                        "Contra toda descrença\n" +
                        "Prevalecerá tua verdade\n" +
                        "\n" +
                        "Nossas mentes\n" +
                        "Vem renovar, pra compreender\n" +
                        "Os teu planos\n" +
                        "Desde o início dos tempos\n" +
                        "Revelada está tua verdade\n" +
                        "\n" +
                        "Recebidas tuas promessas\n" +
                        "Pela fé e graça em Cristo Jesus\n" +
                        "Fale, Ó Deus, vem edificar\n" +
                        "Tua igreja pra tua glória");
        List<Cantico> listaCompleta = new ArrayList<Cantico>();

        int numberOfTitles = listTitles.size();
        int numberOfLyrics = listLyrics.size();

        if(numberOfLyrics == numberOfTitles){
            for(int i = 0; i < 60; i++){
                Cantico cantico = new Cantico();
                cantico.setNumber(Long.valueOf(i + 1));
                cantico.setTitle(listTitles.get(i));
                cantico.setLyrics(listLyrics.get(i));
                listaCompleta.add(cantico);
            }
        }

        return listaCompleta;
    }
}
