package com.pardess.directions.not_use

import com.kakao.vectormap.LatLng
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.model.TrafficState

object RouteExample {
    val BusanSampleData = listOf(
        RouteLine(
            wayList = listOf(
                LatLng.from(35.114465189312, 129.03942485945282),
                LatLng.from(35.11468966833829, 129.0395264409313)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.11468966833829, 129.0395264409313),
                LatLng.from(35.11527316277847, 129.03980810576297)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.11527316277847, 129.03980810576297),
                LatLng.from(35.116161593034356, 129.04026917427962),
                LatLng.from(35.11656491925818, 129.0405375886143),
                LatLng.from(35.11670828003094, 129.0406381443989),
                LatLng.from(35.11684262769507, 129.04073858592017),
                LatLng.from(35.117210089105335, 129.04098460785252)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.117210089105335, 129.04098460785252),
                LatLng.from(35.11726379037176, 129.04102917258436),
                LatLng.from(35.117362462478546, 129.0410852798931),
                LatLng.from(35.11739832610734, 129.04110767699)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.11739832610734, 129.04110767699),
                LatLng.from(35.11754187479801, 129.04118629633044),
                LatLng.from(35.118215117843285, 129.04151300764403)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.118215117843285, 129.04151300764403),
                LatLng.from(35.118304870935795, 129.04155803214746)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.118304870935795, 129.04155803214746),
                LatLng.from(35.1183407344636, 129.0415804297179)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.1183407344636, 129.0415804297179),
                LatLng.from(35.11892394044417, 129.04189503060087)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.11892394044417, 129.04189503060087),
                LatLng.from(35.11983019882128, 129.0423783118873)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.11983019882128, 129.0423783118873),
                LatLng.from(35.11982925542131, 129.04248800737378),
                LatLng.from(35.11981019155492, 129.04260844272588),
                LatLng.from(35.11978211456418, 129.0427287631671),
                LatLng.from(35.11971741915219, 129.04291444125656)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.11971741915219, 129.04291444125656),
                LatLng.from(35.1195876498138, 129.04332967458907)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.1195876498138, 129.04332967458907),
                LatLng.from(35.119569151690555, 129.04338429230773)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.119569151690555, 129.04338429230773),
                LatLng.from(35.11880976145657, 129.04573329106023)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.11880976145657, 129.04573329106023),
                LatLng.from(35.118809004334835, 129.04582104626164),
                LatLng.from(35.118817544099485, 129.04587600845502),
                LatLng.from(35.11885302817765, 129.0459422856658),
                LatLng.from(35.11937294186442, 129.04627805168784),
                LatLng.from(35.11951610817762, 129.04640055997055),
                LatLng.from(35.11956079435293, 129.04644501424042)
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.11956079435293, 129.04644501424042),
                LatLng.from(35.119791911741245, 129.04682097500694)
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.119791911741245, 129.04682097500694),
                LatLng.from(35.119753206745465, 129.04712766043244)
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.119753206745465, 129.04712766043244),
                LatLng.from(35.12242807757608, 129.04843453879062),
                LatLng.from(35.12271535434215, 129.04856987351246),
                LatLng.from(35.123236019287106, 129.04881791267096),
                LatLng.from(35.12346048947603, 129.0489195312295),
                LatLng.from(35.123631451323725, 129.0489546367805),
                LatLng.from(35.12383856002214, 129.04897923465828),
                LatLng.from(35.1240632199337, 129.04905891426165),
                LatLng.from(35.12426956894021, 129.04917127352454),
                LatLng.from(35.124815561437586, 129.04961713174032)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.124815561437586, 129.04961713174032),
                LatLng.from(35.12537729676489, 129.0503265136936)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.12537729676489, 129.0503265136936),
                LatLng.from(35.12579377364117, 129.05115472619752),
                LatLng.from(35.12587327280858, 129.05134226402498),
                LatLng.from(35.12593465055843, 129.0515405408517),
                LatLng.from(35.1259868246127, 129.0517606427809),
                LatLng.from(35.12602836643436, 129.05216712496434),
                LatLng.from(35.126199621440065, 129.05424295842255),
                LatLng.from(35.12625975356192, 129.0545838528871),
                LatLng.from(35.12633023437804, 129.05477127878245)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.12633023437804, 129.05477127878245),
                LatLng.from(35.12641001432041, 129.05492591006146),
                LatLng.from(35.12661482941744, 129.05521381398032),
                LatLng.from(35.12709780338988, 129.0556479405109),
                LatLng.from(35.127634088629975, 129.05617053471332)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.127634088629975, 129.05617053471332),
                LatLng.from(35.12919796082484, 129.05772680515872),
                LatLng.from(35.12948273605275, 129.05814742455948),
                LatLng.from(35.12959798845333, 129.05836835630978),
                LatLng.from(35.12974727966407, 129.05882014248652),
                LatLng.from(35.12979723501232, 129.0592925880393),
                LatLng.from(35.13001838070327, 129.06286138278483),
                LatLng.from(35.13003448211315, 129.06308103390148)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.13003448211315, 129.06308103390148),
                LatLng.from(35.13008307281709, 129.06370707516342)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.13008307281709, 129.06370707516342),
                LatLng.from(35.13025022677378, 129.06520145747817),
                LatLng.from(35.130267191886695, 129.06532237176484),
                LatLng.from(35.13033726989946, 129.06555369925337),
                LatLng.from(35.13052316465838, 129.06594014641075),
                LatLng.from(35.13070973381952, 129.06624979884225),
                LatLng.from(35.131094296733906, 129.0665949511512),
                LatLng.from(35.131525468412654, 129.066765158088),
                LatLng.from(35.131804192850765, 129.06684559963912),
                LatLng.from(35.132056457956956, 129.06685986244304),
                LatLng.from(35.13326496136254, 129.06678784620743),
                LatLng.from(35.133598439226645, 129.06679219596535),
                LatLng.from(35.134012453812744, 129.0668634320571),
                LatLng.from(35.13423710054139, 129.0669431711227),
                LatLng.from(35.136418346732874, 129.06798113997843),
                LatLng.from(35.13655247667014, 129.06810359427),
                LatLng.from(35.13669484563437, 129.0683139404501),
                LatLng.from(35.13680009838138, 129.0686445053425),
                LatLng.from(35.13684322765689, 129.06886452898527),
                LatLng.from(35.13686774995014, 129.06915014762635),
                LatLng.from(35.136904862620355, 129.07209139887448)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.136904862620355, 129.07209139887448),
                LatLng.from(35.1369037948497, 129.0722120879371)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.1369037948497, 129.0722120879371),
                LatLng.from(35.13691997602244, 129.07242078724184),
                LatLng.from(35.13693635105897, 129.07260754314856)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.13693635105897, 129.07260754314856),
                LatLng.from(35.136916285716254, 129.07283771309963),
                LatLng.from(35.136976267215694, 129.07318963647074),
                LatLng.from(35.13703683084241, 129.07347572985725),
                LatLng.from(35.13713237590159, 129.07388298636616),
                LatLng.from(35.13725486097057, 129.0743015707782)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.13725486097057, 129.0743015707782),
                LatLng.from(35.137483455594, 129.07495198566386)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.137483455594, 129.07495198566386),
                LatLng.from(35.139433456009705, 129.07968518282283)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.139433456009705, 129.07968518282283),
                LatLng.from(35.141127293103466, 129.08381166137656),
                LatLng.from(35.14183172174808, 129.085675546286),
                LatLng.from(35.14276779563469, 129.08783883632523),
                LatLng.from(35.14340558238852, 129.0890873686342),
                LatLng.from(35.14431127205602, 129.09061384283137)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.14431127205602, 129.09061384283137),
                LatLng.from(35.145874094355754, 129.0932355742626)
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.145874094355754, 129.0932355742626),
                LatLng.from(35.145971948255955, 129.09337954745007),
                LatLng.from(35.14717639256629, 129.09475647779465)
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.14717639256629, 129.09475647779465),
                LatLng.from(35.14736437267054, 129.09490166229597)
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.14736437267054, 129.09490166229597),
                LatLng.from(35.147731319493836, 129.09519191256862)
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.147731319493836, 129.09519191256862),
                LatLng.from(35.149118381058024, 129.09630795884505)
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.149118381058024, 129.09630795884505),
                LatLng.from(35.15772712333777, 129.10320647233195),
                LatLng.from(35.158595564015975, 129.1038547986058)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.158595564015975, 129.1038547986058),
                LatLng.from(35.15903478940191, 129.1041241549354),
                LatLng.from(35.15918740627462, 129.10419207301948),
                LatLng.from(35.159672494992165, 129.1043742449608),
                LatLng.from(35.16169756463244, 129.10470895437854),
                LatLng.from(35.16212957657408, 129.10478065404325),
                LatLng.from(35.162534349966556, 129.10487393897688),
                LatLng.from(35.1630284499375, 129.10505624485805),
                LatLng.from(35.163378545728136, 129.10521465176018),
                LatLng.from(35.16361177588279, 129.10533854913072),
                LatLng.from(35.16426660204079, 129.1056876850649)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16426660204079, 129.1056876850649),
                LatLng.from(35.16769353038323, 129.1074794307038)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16769353038323, 129.1074794307038),
                LatLng.from(35.168249711025666, 129.10777237827767)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.168249711025666, 129.10777237827767),
                LatLng.from(35.1769514180691, 129.11232566873724)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.1769514180691, 129.11232566873724),
                LatLng.from(35.179884854269474, 129.1138587398458)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.179884854269474, 129.1138587398458),
                LatLng.from(35.18002794699352, 129.1139814582752),
                LatLng.from(35.181354655691635, 129.11477906478524),
                LatLng.from(35.1813814917082, 129.11480138908613),
                LatLng.from(35.181470305070235, 129.11494532808499),
                LatLng.from(35.18152276425364, 129.1151217076901),
                LatLng.from(35.181538565846665, 129.11536346042914),
                LatLng.from(35.18150099855461, 129.1155276313542),
                LatLng.from(35.181064040615325, 129.11599375287108),
                LatLng.from(35.18094566171445, 129.1161238811188)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.18094566171445, 129.1161238811188),
                LatLng.from(35.18047406750056, 129.11643581934143),
                LatLng.from(35.18002110517407, 129.1166821364109)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.18002110517407, 129.1166821364109),
                LatLng.from(35.17965857300255, 129.1168967518351)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17965857300255, 129.1168967518351),
                LatLng.from(35.179486623179585, 129.1169712502885)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.179486623179585, 129.1169712502885),
                LatLng.from(35.17897938111939, 129.1172387760124)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17897938111939, 129.1172387760124),
                LatLng.from(35.178499682959014, 129.11745178278576)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.178499682959014, 129.11745178278576),
                LatLng.from(35.17793026264006, 129.11761964512274)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17793026264006, 129.11761964512274),
                LatLng.from(35.17738808276964, 129.11776592136064)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17738808276964, 129.11776592136064),
                LatLng.from(35.17656549595547, 129.11801813952462)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17656549595547, 129.11801813952462),
                LatLng.from(35.17591425118157, 129.11826172113652)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17591425118157, 129.11826172113652),
                LatLng.from(35.1753437147358, 129.11855031694606)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.1753437147358, 129.11855031694606),
                LatLng.from(35.1751258894184, 129.11871200444355),
                LatLng.from(35.17475261714781, 129.1191130779258)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17475261714781, 129.1191130779258),
                LatLng.from(35.17418865658982, 129.11966522496274),
                LatLng.from(35.17414328871772, 129.11969753677155)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17414328871772, 129.11969753677155),
                LatLng.from(35.174320904112584, 129.11998539945242)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.174320904112584, 129.11998539945242),
                LatLng.from(35.175082487879436, 129.12145592874575)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.175082487879436, 129.12145592874575),
                LatLng.from(35.176569956901204, 129.12435266484104)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.176569956901204, 129.12435266484104),
                LatLng.from(35.17659658734317, 129.12439694462915)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17659658734317, 129.12439694462915),
                LatLng.from(35.1765512182579, 129.12442925468935)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.1765512182579, 129.12442925468935),
                LatLng.from(35.176487619999584, 129.1244832701986)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.176487619999584, 129.1244832701986),
                LatLng.from(35.17490697475675, 129.12580082515464),
                LatLng.from(35.174852286557574, 129.12586593941657),
                LatLng.from(35.17474250189202, 129.1260400741399)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17474250189202, 129.1260400741399),
                LatLng.from(35.174578436819075, 129.12623541578833),
                LatLng.from(35.174321896655215, 129.12668197425046),
                LatLng.from(35.173998997190445, 129.12747890744996)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.173998997190445, 129.12747890744996),
                LatLng.from(35.173575317208716, 129.12845008769764),
                LatLng.from(35.17335522892916, 129.12885322625678),
                LatLng.from(35.17320908247284, 129.12905978449146)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17320908247284, 129.12905978449146),
                LatLng.from(35.17301756534146, 129.129298647959),
                LatLng.from(35.17172763101316, 129.13036759432495)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17172763101316, 129.13036759432495),
                LatLng.from(35.17071954045202, 129.13117695245737)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17071954045202, 129.13117695245737),
                LatLng.from(35.17051972424902, 129.13133884667846)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17051972424902, 129.13133884667846),
                LatLng.from(35.170337830638594, 129.1315119658411)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.170337830638594, 129.1315119658411),
                LatLng.from(35.169347963250864, 129.13229959450138)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.169347963250864, 129.13229959450138),
                LatLng.from(35.16917518359433, 129.13246185819574)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16917518359433, 129.13246185819574),
                LatLng.from(35.169255066148985, 129.13259469309907)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.169255066148985, 129.13259469309907),
                LatLng.from(35.169840353337925, 129.13362370324475)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.169840353337925, 129.13362370324475),
                LatLng.from(35.17036305692102, 129.13459697157398)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17036305692102, 129.13459697157398),
                LatLng.from(35.170487691846546, 129.1347633645896),
                LatLng.from(35.17072702259872, 129.13519481125036),
                LatLng.from(35.17089682279789, 129.13535085630096)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17089682279789, 129.13535085630096),
                LatLng.from(35.170940960116056, 129.1354502673671)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.170940960116056, 129.1354502673671),
                LatLng.from(35.17074644598188, 129.13600741419984),
                LatLng.from(35.17065395169501, 129.1362586092272),
                LatLng.from(35.17057968815375, 129.13648810247292)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.17057968815375, 129.13648810247292),
                LatLng.from(35.170542504727635, 129.13660833694072),
                LatLng.from(35.170505630182966, 129.13669564328032)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.170505630182966, 129.13669564328032),
                LatLng.from(35.17049641153714, 129.13671746985267),
                LatLng.from(35.170450524268105, 129.13680465064462)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.170450524268105, 129.13680465064462),
                LatLng.from(35.170441305603084, 129.13682647718957),
                LatLng.from(35.170404533921634, 129.13690280732848),
                LatLng.from(35.17031337723731, 129.13701131253544),
                LatLng.from(35.17024034878773, 129.13710909249474),
                LatLng.from(35.170121844847436, 129.13725014863357),
                LatLng.from(35.169848373609916, 129.1375756612384),
                LatLng.from(35.1697845635328, 129.137651613866),
                LatLng.from(35.16969350929198, 129.1377491415218),
                LatLng.from(35.169493272183594, 129.1379549209096),
                LatLng.from(35.169356638879265, 129.1381066992091)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.169356638879265, 129.1381066992091),
                LatLng.from(35.16896527895719, 129.1385074033791)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16896527895719, 129.1385074033791),
                LatLng.from(35.16878224045008, 129.13880123651506)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16878224045008, 129.13880123651506),
                LatLng.from(35.16865482515862, 129.13893118626083)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16865482515862, 129.13893118626083),
                LatLng.from(35.16825300462684, 129.13948541703158)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16825300462684, 129.13948541703158),
                LatLng.from(35.168116266210454, 129.13964816614288),
                LatLng.from(35.16787904588356, 129.13995221459214)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16787904588356, 129.13995221459214),
                LatLng.from(35.16764265129383, 129.1401684564157),
                LatLng.from(35.16695293755488, 129.14066376899962)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16695293755488, 129.14066376899962),
                LatLng.from(35.16689844831032, 129.14070691588017),
                LatLng.from(35.16639022593582, 129.14107303256583),
                LatLng.from(35.166099856988865, 129.1412775363397)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.166099856988865, 129.1412775363397),
                LatLng.from(35.16541966875079, 129.1417180799005)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16541966875079, 129.1417180799005),
                LatLng.from(35.16502953896282, 129.14198704465687),
                LatLng.from(35.16466644651846, 129.14225638494568),
                LatLng.from(35.16426668186456, 129.14259106953716),
                LatLng.from(35.16408477271517, 129.1427641503245)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16408477271517, 129.1427641503245),
                LatLng.from(35.16384702706433, 129.1431230502576)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16384702706433, 129.1431230502576),
                LatLng.from(35.1635635956083, 129.1435471676097),
                LatLng.from(35.16335278197769, 129.14391741656144),
                LatLng.from(35.163077427366126, 129.1444404296073)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.163077427366126, 129.1444404296073),
                LatLng.from(35.16261829059813, 129.1453340599228)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16261829059813, 129.1453340599228),
                LatLng.from(35.16226005147562, 129.14604249837225)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16226005147562, 129.14604249837225),
                LatLng.from(35.162067047952526, 129.14643493746007)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.162067047952526, 129.14643493746007),
                LatLng.from(35.16201203740565, 129.14653295207756)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16201203740565, 129.14653295207756),
                LatLng.from(35.16180981189491, 129.14694721185856)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16180981189491, 129.14694721185856),
                LatLng.from(35.161424733614034, 129.14763330676013)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.161424733614034, 129.14763330676013),
                LatLng.from(35.160995524622315, 129.1482199896157),
                LatLng.from(35.16053948314194, 129.1487843368734),
                LatLng.from(35.160393511861066, 129.14896887752053),
                LatLng.from(35.16011844838346, 129.1494589305728)
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.16011844838346, 129.1494589305728),
                LatLng.from(35.15981613676396, 129.14997054878808)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15981613676396, 129.14997054878808),
                LatLng.from(35.158992075985594, 129.15131995884119),
                LatLng.from(35.15895550403101, 129.15137432284862)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15895550403101, 129.15137432284862),
                LatLng.from(35.15869163466163, 129.1516340245218),
                LatLng.from(35.15839192297114, 129.15187126766335)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15839192297114, 129.15187126766335),
                LatLng.from(35.15801015797455, 129.15220613379063)
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15801015797455, 129.15220613379063),
                LatLng.from(35.1580947510549, 129.1527890414037)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.1580947510549, 129.1527890414037),
                LatLng.from(35.158179550258474, 129.1533500015752)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.158179550258474, 129.1533500015752),
                LatLng.from(35.15824966595009, 129.1535595308992)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15824966595009, 129.1535595308992),
                LatLng.from(35.15844104457565, 129.15428663521533)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15844104457565, 129.15428663521533),
                LatLng.from(35.158501832261926, 129.15452896160383)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.158501832261926, 129.15452896160383),
                LatLng.from(35.158535581630545, 129.1547709062191)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.158535581630545, 129.1547709062191),
                LatLng.from(35.15855759726853, 129.15529805618868)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15855759726853, 129.15529805618868),
                LatLng.from(35.15855529466751, 129.15553949140894)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15855529466751, 129.15553949140894),
                LatLng.from(35.1585336052378, 129.15592333783758)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.1585336052378, 129.15592333783758),
                LatLng.from(35.15851820351755, 129.15659264387105),
                LatLng.from(35.15856138050844, 129.1567908195771)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15856138050844, 129.1567908195771),
                LatLng.from(35.15857877696633, 129.1568569207251)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15857877696633, 129.1568569207251),
                LatLng.from(35.15887881106328, 129.15753069555817)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15887881106328, 129.15753069555817),
                LatLng.from(35.159087980890604, 129.1582800184339)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.159087980890604, 129.1582800184339),
                LatLng.from(35.15927933079676, 129.15900714051273)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15927933079676, 129.15900714051273),
                LatLng.from(35.159459982637706, 129.15990972888056)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.159459982637706, 129.15990972888056),
                LatLng.from(35.15954464339784, 129.16048167935284)
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(35.15954464339784, 129.16048167935284),
                LatLng.from(35.15938325775974, 129.1603915798554),
                LatLng.from(35.15933128434538, 129.1601713236064)
            ),
            trafficState = TrafficState.UNKNOWN
        )
    )

    val SampleBigData = listOf(
        RouteLine(
            wayList = listOf(
                LatLng.from(37.55595957732287, 126.97227318174524),
                LatLng.from(37.55584147066708, 126.97216162420102),
            ),
            trafficState = TrafficState.UNKNOWN
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.55584147066708, 126.97216162420102),
                LatLng.from(37.55559733155492, 126.97206311621702),
                LatLng.from(37.55519161526699, 126.97203473574871),
                LatLng.from(37.554687190209926, 126.97205298264262),
            ),
            trafficState = TrafficState.UNKNOWN
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.554687190209926, 126.97205298264262),
                LatLng.from(37.5545443213368, 126.97220207607867),
                LatLng.from(37.554491348781895, 126.9723272989492),
            ),
            trafficState = TrafficState.UNKNOWN
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.554491348781895, 126.9723272989492),
                LatLng.from(37.55443817911599, 126.97242988884997),
                LatLng.from(37.554312934542295, 126.97253346817439),
            ),
            trafficState = TrafficState.UNKNOWN
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.554312934542295, 126.97253346817439),
                LatLng.from(37.55352080080895, 126.97262356700553),
                LatLng.from(37.553385562036304, 126.97261410598193),
                LatLng.from(37.551317889295014, 126.97212189512535),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.551317889295014, 126.97212189512535),
                LatLng.from(37.54970186461925, 126.97175930915527),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.54970186461925, 126.97175930915527),
                LatLng.from(37.54951227394457, 126.9717166456792),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.54951227394457, 126.9717166456792),
                LatLng.from(37.54876420161901, 126.97169297201255),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.54876420161901, 126.97169297201255),
                LatLng.from(37.54517946121222, 126.97185537893996),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.54517946121222, 126.97185537893996),
                LatLng.from(37.545080555248774, 126.97187937000132),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.545080555248774, 126.97187937000132),
                LatLng.from(37.5443434619695, 126.9720818687329),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.5443434619695, 126.9720818687329),
                LatLng.from(37.54359726034583, 126.97227317223515),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.54359726034583, 126.97227317223515),
                LatLng.from(37.54205990730176, 126.97266769995856),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.54205990730176, 126.97266769995856),
                LatLng.from(37.541115793309714, 126.97289565358933),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.541115793309714, 126.97289565358933),
                LatLng.from(37.540342856774146, 126.97312125352043),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.540342856774146, 126.97312125352043),
                LatLng.from(37.537600700978096, 126.97381514124338),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.537600700978096, 126.97381514124338),
                LatLng.from(37.53747476627157, 126.97383949745378),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53747476627157, 126.97383949745378),
                LatLng.from(37.536458770376825, 126.97409103587857),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.536458770376825, 126.97409103587857),
                LatLng.from(37.5359901841062, 126.97408614048666),
                LatLng.from(37.53566388027694, 126.97386431252335),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53566388027694, 126.97386431252335),
                LatLng.from(37.53557575239915, 126.97409181808435),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53557575239915, 126.97409181808435),
                LatLng.from(37.53518523465268, 126.97477605837648),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53518523465268, 126.97477605837648),
                LatLng.from(37.53515859936474, 126.97482168236614),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53515859936474, 126.97482168236614),
                LatLng.from(37.53505195983121, 126.97499286452553),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53505195983121, 126.97499286452553),
                LatLng.from(37.534891950960805, 126.97524398012796),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.534891950960805, 126.97524398012796),
                LatLng.from(37.53477669402952, 126.97546053808982),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53477669402952, 126.97546053808982),
                LatLng.from(37.53466251609376, 126.9758015430132),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53466251609376, 126.9758015430132),
                LatLng.from(37.534610421959016, 126.97602855056171),
                LatLng.from(37.534717171544465, 126.97899156130065),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.534717171544465, 126.97899156130065),
                LatLng.from(37.534795190590145, 126.98072165991157),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.534795190590145, 126.98072165991157),
                LatLng.from(37.53493780404861, 126.98472516174729),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53493780404861, 126.98472516174729),
                LatLng.from(37.53496813876973, 126.98510945427147),
                LatLng.from(37.53495429985457, 126.98559617887824),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53495429985457, 126.98559617887824),
                LatLng.from(37.534928826404766, 126.9857775609205),
                LatLng.from(37.53485065613737, 126.98611806359935),
                LatLng.from(37.5346137131483, 126.98685673117473),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.5346137131483, 126.98685673117473),
                LatLng.from(37.53453515159941, 126.98715197759262),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53453515159941, 126.98715197759262),
                LatLng.from(37.534231838697764, 126.98750683570357),
                LatLng.from(37.5337681971206, 126.98807883586208),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.5337681971206, 126.98807883586208),
                LatLng.from(37.5336612472344, 126.98821605642155),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.5336612472344, 126.98821605642155),
                LatLng.from(37.53361678165671, 126.98828454484553),
                LatLng.from(37.5327596266826, 126.98920128289386),
                LatLng.from(37.5327418983156, 126.98923546561628),
                LatLng.from(37.532652772243694, 126.9893498131637),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.532652772243694, 126.9893498131637),
                LatLng.from(37.53223213616772, 126.98968360714221),
                LatLng.from(37.53189180991745, 126.98992579948816),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53189180991745, 126.98992579948816),
                LatLng.from(37.53042286947153, 126.9909525673588),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.53042286947153, 126.9909525673588),
                LatLng.from(37.53003749313808, 126.99119535467446),
                LatLng.from(37.52982203958974, 126.99128876884153),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.52982203958974, 126.99128876884153),
                LatLng.from(37.52941700117017, 126.9913394794073),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.52941700117017, 126.9913394794073),
                LatLng.from(37.52882286098571, 126.99140404957403),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.52882286098571, 126.99140404957403),
                LatLng.from(37.527292800889, 126.9916056697434),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.527292800889, 126.9916056697434),
                LatLng.from(37.52619461407226, 126.99173358768206),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.52619461407226, 126.99173358768206),
                LatLng.from(37.525879766212945, 126.9917943925527),
                LatLng.from(37.52575411675283, 126.9918526507441),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.52575411675283, 126.9918526507441),
                LatLng.from(37.525270213236254, 126.99216462349924),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.525270213236254, 126.99216462349924),
                LatLng.from(37.52435694251329, 126.99284438962),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.52435694251329, 126.99284438962),
                LatLng.from(37.524231581838016, 126.9929365805354),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.524231581838016, 126.9929365805354),
                LatLng.from(37.52359451436899, 126.9932505979471),
                LatLng.from(37.523316281798614, 126.99337878047444),
                LatLng.from(37.52303775985617, 126.99347302684758),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.52303775985617, 126.99347302684758),
                LatLng.from(37.522821629244774, 126.9934872434516),
                LatLng.from(37.52211084587034, 126.99360992099257),
                LatLng.from(37.519529177098164, 126.99411972129046),
                LatLng.from(37.51931343156519, 126.99417917980246),
                LatLng.from(37.519035197630565, 126.9943073512162),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.519035197630565, 126.9943073512162),
                LatLng.from(37.51869408985555, 126.99445899013483),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.51869408985555, 126.99445899013483),
                LatLng.from(37.51741975113134, 126.99506432346769),
                LatLng.from(37.5168365410234, 126.99535494675382),
                LatLng.from(37.51476352559626, 126.99634423801032),
                LatLng.from(37.51380325858529, 126.99679825144074),
                LatLng.from(37.512439290825775, 126.99746125976621),
                LatLng.from(37.5107880701754, 126.99825250596427),
                LatLng.from(37.510509447357315, 126.99833540763883),
                LatLng.from(37.51008743976397, 126.99851071319972),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.51008743976397, 126.99851071319972),
                LatLng.from(37.50997990118956, 126.99858001635835),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50997990118956, 126.99858001635835),
                LatLng.from(37.50937866189978, 126.99887082297181),
                LatLng.from(37.50923508510423, 126.99894060622519),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50923508510423, 126.99894060622519),
                LatLng.from(37.50759257487751, 126.99969773615172),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50759257487751, 126.99969773615172),
                LatLng.from(37.50736963563033, 126.9999721669404),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50736963563033, 126.9999721669404),
                LatLng.from(37.50730676061682, 126.99999562701431),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50730676061682, 126.99999562701431),
                LatLng.from(37.505466703006896, 127.00083451916574),
                LatLng.from(37.50503606402977, 127.0010551545033),
                LatLng.from(37.50472254818326, 127.0012742269883),
                LatLng.from(37.503058340412764, 127.00266490765729),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.503058340412764, 127.00266490765729),
                LatLng.from(37.50276303124323, 127.0029063452731),
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50276303124323, 127.0029063452731),
                LatLng.from(37.50263775708037, 127.00300980083531),
                LatLng.from(37.502244201209365, 127.00335433083164),
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.502244201209365, 127.00335433083164),
                LatLng.from(37.50199307956403, 127.00349338713781),
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50199307956403, 127.00349338713781),
                LatLng.from(37.502186189916785, 127.00395452578462),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.502186189916785, 127.00395452578462),
                LatLng.from(37.502232191012006, 127.00406701358467),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.502232191012006, 127.00406701358467),
                LatLng.from(37.50266459615019, 127.00512440573982),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50266459615019, 127.00512440573982),
                LatLng.from(37.502830671663695, 127.00558591130832),
                LatLng.from(37.50309746767106, 127.00623835406142),
                LatLng.from(37.503343578514894, 127.00657439376025),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.503343578514894, 127.00657439376025),
                LatLng.from(37.50454956142881, 127.00962348989026),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50454956142881, 127.00962348989026),
                LatLng.from(37.50457715890861, 127.00969098682181),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50457715890861, 127.00969098682181),
                LatLng.from(37.50459565201353, 127.00974729380451),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50459565201353, 127.00974729380451),
                LatLng.from(37.50475412149845, 127.01037857615103),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50475412149845, 127.01037857615103),
                LatLng.from(37.50485027834672, 127.011101165544),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50485027834672, 127.011101165544),
                LatLng.from(37.50489331959742, 127.011937559938),
                LatLng.from(37.504881068896516, 127.01262764956886),
                LatLng.from(37.50481409563758, 127.01323928719346),
                LatLng.from(37.50463216634433, 127.01411257188451),
                LatLng.from(37.50449159958141, 127.0145442095286),
                LatLng.from(37.504377211068054, 127.01487370959742),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.504377211068054, 127.01487370959742),
                LatLng.from(37.50418371538471, 127.01544176188347),
                LatLng.from(37.504051116767194, 127.01574887795017),
                LatLng.from(37.50336773994265, 127.0170019573459),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50336773994265, 127.0170019573459),
                LatLng.from(37.50335009726103, 127.0170474289459),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.50335009726103, 127.0170474289459),
                LatLng.from(37.50308169249663, 127.01727714846459),
                LatLng.from(37.502868191072245, 127.01760793684831),
                LatLng.from(37.502645397073294, 127.01790491516267),
                LatLng.from(37.50244015143835, 127.01814511223908),
                LatLng.from(37.50225254850323, 127.01833983738426),
                LatLng.from(37.50202008534518, 127.01855776851377),
                LatLng.from(37.50174257395361, 127.01877628781237),
                LatLng.from(37.50145586473068, 127.01897230624074),
                LatLng.from(37.50124958390654, 127.0190881027539),
                LatLng.from(37.500756311312266, 127.0193659881784),
            ),
            trafficState = TrafficState.JAM
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.500756311312266, 127.0193659881784),
                LatLng.from(37.49636413781493, 127.02105192324737),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.49636413781493, 127.02105192324737),
                LatLng.from(37.49557363739883, 127.0213449646168),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.49557363739883, 127.0213449646168),
                LatLng.from(37.49113638060644, 127.0230312478834),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.49113638060644, 127.0230312478834),
                LatLng.from(37.49078612862094, 127.02317150802585),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.49078612862094, 127.02317150802585),
                LatLng.from(37.48755220491818, 127.02436700450141),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.48755220491818, 127.02436700450141),
                LatLng.from(37.48714798671758, 127.02451926071896),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.48714798671758, 127.02451926071896),
                LatLng.from(37.48529732822028, 127.02518784335508),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.48529732822028, 127.02518784335508),
                LatLng.from(37.48394098134899, 127.02570298100206),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.48394098134899, 127.02570298100206),
                LatLng.from(37.483599641789, 127.02583179167141),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.483599641789, 127.02583179167141),
                LatLng.from(37.48323127322722, 127.02596095202952),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.48323127322722, 127.02596095202952),
                LatLng.from(37.4828990361158, 127.02610094907915),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.4828990361158, 127.02610094907915),
                LatLng.from(37.481335556295086, 127.0266300466144),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.481335556295086, 127.0266300466144),
                LatLng.from(37.475793831333675, 127.0287935220071),
                LatLng.from(37.47454734464867, 127.02952191369769),
                LatLng.from(37.47372337786917, 127.03013176546878),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.47372337786917, 127.03013176546878),
                LatLng.from(37.47339252628579, 127.03044129100114),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.47339252628579, 127.03044129100114),
                LatLng.from(37.47197947804232, 127.031737048796),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.47197947804232, 127.031737048796),
                LatLng.from(37.47151477363281, 127.03220656001368),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.47151477363281, 127.03220656001368),
                LatLng.from(37.468376052019885, 127.03514105779483),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.468376052019885, 127.03514105779483),
                LatLng.from(37.4676071263379, 127.0358744412044),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.4676071263379, 127.0358744412044),
                LatLng.from(37.46624816440277, 127.03718060579479),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.46624816440277, 127.03718060579479),
                LatLng.from(37.46412878936889, 127.03916340731878),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.46412878936889, 127.03916340731878),
                LatLng.from(37.46367260387536, 127.03957619312749),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.46367260387536, 127.03957619312749),
                LatLng.from(37.463172011197656, 127.04006866989724),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.463172011197656, 127.04006866989724),
                LatLng.from(37.46266222311534, 127.04053864962543),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.46266222311534, 127.04053864962543),
                LatLng.from(37.46094556751398, 127.04218831748021),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.46094556751398, 127.04218831748021),
                LatLng.from(37.45922861299148, 127.04380400270941),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.45922861299148, 127.04380400270941),
                LatLng.from(37.458647371274, 127.044353964799),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.458647371274, 127.044353964799),
                LatLng.from(37.45420256096784, 127.04850209517598),
                LatLng.from(37.44599044743705, 127.05594075449392),
                LatLng.from(37.44493424430589, 127.05682422625601),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.44493424430589, 127.05682422625601),
                LatLng.from(37.44426238964349, 127.05731861182126),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.44426238964349, 127.05731861182126),
                LatLng.from(37.43970206311599, 127.06059646878543),
                LatLng.from(37.43893198121294, 127.06120501658926),
                LatLng.from(37.43767030351666, 127.06231689817066),
                LatLng.from(37.42889164374638, 127.07116045398679),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.42889164374638, 127.07116045398679),
                LatLng.from(37.42849831848152, 127.07156077312257),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.42849831848152, 127.07156077312257),
                LatLng.from(37.41686653952456, 127.08323872172886),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.41686653952456, 127.08323872172886),
                LatLng.from(37.41575807073399, 127.08438192676418),
                LatLng.from(37.410080315927246, 127.09008778443673),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.410080315927246, 127.09008778443673),
                LatLng.from(37.40868554368245, 127.0915053434431),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.40868554368245, 127.0915053434431),
                LatLng.from(37.40817597091813, 127.09203110398764),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.40817597091813, 127.09203110398764),
                LatLng.from(37.40713030806583, 127.0931506971049),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.40713030806583, 127.0931506971049),
                LatLng.from(37.406799540174006, 127.09349355194763),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.406799540174006, 127.09349355194763),
                LatLng.from(37.40670121059135, 127.09359639695644),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.40670121059135, 127.09359639695644),
                LatLng.from(37.40652248437838, 127.09379057461179),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.40652248437838, 127.09379057461179),
                LatLng.from(37.404188967139966, 127.0961793780722),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.404188967139966, 127.0961793780722),
                LatLng.from(37.402979877016584, 127.09714268343168),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.402979877016584, 127.09714268343168),
                LatLng.from(37.40119124712379, 127.09891483145311),
                LatLng.from(37.40068875671546, 127.09919192072798),
                LatLng.from(37.40019467337389, 127.09938984332523),
                LatLng.from(37.399753617095776, 127.09945159422453),
                LatLng.from(37.39942024981575, 127.09945558332642),
                LatLng.from(37.39881598258817, 127.09938375300901),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39881598258817, 127.09938375300901),
                LatLng.from(37.39801547510493, 127.09957404085957),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39801547510493, 127.09957404085957),
                LatLng.from(37.3976026521064, 127.09979357005872),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.3976026521064, 127.09979357005872),
                LatLng.from(37.397370113223666, 127.1000222352213),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.397370113223666, 127.1000222352213),
                LatLng.from(37.39727186346962, 127.10013635182497),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39727186346962, 127.10013635182497),
                LatLng.from(37.3970933834797, 127.10036436874783),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.3970933834797, 127.10036436874783),
                LatLng.from(37.39657724833268, 127.10121759354453),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39657724833268, 127.10121759354453),
                LatLng.from(37.395947492731345, 127.10253521529613),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.395947492731345, 127.10253521529613),
                LatLng.from(37.39569658565666, 127.10271891007858),
                LatLng.from(37.39564304015691, 127.10278731200754),
                LatLng.from(37.39562527733246, 127.10282140554048),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39562527733246, 127.10282140554048),
                LatLng.from(37.39501095605719, 127.10379999824272),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39501095605719, 127.10379999824272),
                LatLng.from(37.394637244111024, 127.10442560596098),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.394637244111024, 127.10442560596098),
                LatLng.from(37.39452165414758, 127.10463026906876),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39452165414758, 127.10463026906876),
                LatLng.from(37.39423718261785, 127.10514187054788),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39423718261785, 127.10514187054788),
                LatLng.from(37.39416621391096, 127.10528953254264),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39416621391096, 127.10528953254264),
                LatLng.from(37.39431472944153, 127.10586374791716),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39431472944153, 127.10586374791716),
                LatLng.from(37.39449629457429, 127.10604229142072),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39449629457429, 127.10604229142072),
                LatLng.from(37.39458716240711, 127.10614285626038),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39458716240711, 127.10614285626038),
                LatLng.from(37.39490464448217, 127.1064214318113),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39490464448217, 127.1064214318113),
                LatLng.from(37.395158288398264, 127.10659912252072),
                LatLng.from(37.3956289385873, 127.106875884624),
                LatLng.from(37.39587280431328, 127.10695204877287),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39587280431328, 127.10695204877287),
                LatLng.from(37.396054453109976, 127.10714189154415),
            ),
            trafficState = TrafficState.NORMAL
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.396054453109976, 127.10714189154415),
                LatLng.from(37.39616427775732, 127.10736646910716),
                LatLng.from(37.39622055363321, 127.10765944638445),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39622055363321, 127.10765944638445),
                LatLng.from(37.396218528358986, 127.10858558055357),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.396218528358986, 127.10858558055357),
                LatLng.from(37.396226781360426, 127.10968100356395),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.396226781360426, 127.10968100356395),
                LatLng.from(37.39622244643168, 127.11030222640413),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39622244643168, 127.11030222640413),
                LatLng.from(37.396223720873245, 127.11047162177373),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.396223720873245, 127.11047162177373),
                LatLng.from(37.39622065509858, 127.11126224002652),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39622065509858, 127.11126224002652),
                LatLng.from(37.396226593999046, 127.11205275202975),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.396226593999046, 127.11205275202975),
                LatLng.from(37.39622812029087, 127.11225602658233),
            ),
            trafficState = TrafficState.DELAY
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39622812029087, 127.11225602658233),
                LatLng.from(37.39623176501827, 127.11274162696445),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39623176501827, 127.11274162696445),
                LatLng.from(37.39607851088462, 127.11273213951702),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39607851088462, 127.11273213951702),
                LatLng.from(37.395051290099225, 127.11273295435316),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.395051290099225, 127.11273295435316),
                LatLng.from(37.39470891137642, 127.11273699016535),
            ),
            trafficState = TrafficState.SLOW
        ),
        RouteLine(
            wayList = listOf(
                LatLng.from(37.39470891137642, 127.11273699016535),
                LatLng.from(37.39472345624831, 127.11227377269273),
            ),
            trafficState = TrafficState.UNKNOWN
        )
    )
}

