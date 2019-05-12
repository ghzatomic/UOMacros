##########################
#####FUNCAO PRINCIPAL#####
##########################
sub FullBook()
uo.charprint('0x0003','Iniciando Macro')
uo.charprint('0x0003','Fazer FullBook')
wait(1000)
lag()
fzScroll()
uo.charprint('0x0003','Fazendo Book de Spells')
wait(1000)
lag()
fzBook()
uo.charprint('0x0003','Guardando os Scrolls')
wait(1000)
lag()
porScroll()
uo.charprint('0x0003','Obrigado por ultilizar o macro')
uo.charprint('0x0003','Finalizando!')
endsub

######################################
#####FUNCAO PARA FAZER OS SCROLLS#####
######################################
Sub fzScroll()
var i, k, sair = 0
DIM nomes[8]
nomes[1] = "Reactive Armor Scr"
nomes[2] = "Agility Scroll"
nomes[3] = "Bless Scroll"
nomes[4] = "Archcure Scroll"
nomes[5] = "Blade Spirits Scro"
nomes[6] = "Dispel Scroll"
nomes[7] = "Chain Lightning Sc"
nomes[8] = "Earthquake Scroll"

uo.usetype('0x0FBF')
repeat
        wait(100)
until uo.lastgump( 'replyed' ) == 0 and uo.lastgump( 'text', 4 ) == 'Primeiro Circulo'
for i = 1 to 8
                uo.charprint('0x0026',''+str(i)+'º Circulo')
        uo.lclick(68,i*20+98)
                repeat
                        wait(100)
                until uo.lastgump( 'replyed' ) == 0 and uo.lastgump( 'text', 14 ) == nomes[i]
        for k = 1 to 8
                uo.deletejournal()
                sair = 0
                if i == 1 and k == 3 then
                        k = 4
                        uo.charprint('0x0026','Pulando Spell Desabilitada')
                endif
                if i == 4 and k == 3 then
                        k = 4
                        uo.charprint('0x0026','Pulando Spell Desabilitada')
                endif
                if i == 5 and k == 3 then
                        k = 4
                        uo.charprint('0x0026','Pulando Spell Desabilitada')
                endif
                if i == 7 and k == 8 then
                                                sair = 81
                                                uo.charprint('0x0026','Pulando Spell Desabilitada')
                endif
                uo.lclick(235,k*20+98)
                repeat
                        wait(100)
                until uo.injournal('Voce pos|Voce falhou') or sair > 80
                if uo.injournal('Voce falhou') then
                        k = k - 1
                endif
        next
next
end sub
####################################
#####FUNCAO PARA FAZER O BOOK#######
####################################
Sub fzBook()
repeat
        uo.deletejournal()
        uo.lclick(72,277)
        repeat
                wait(100)
        until uo.lastgump( 'replyed' ) == 0 and uo.lastgump( 'text', 14 ) == "spellbook"
        uo.lclick(234,113)
        repeat
                wait(100)
        until uo.injournal('Voce pos|Voce falhou|Skill I')
until NOT uo.injournal('Voce falhou|Skill I')

repeat
        uo.findtype('0x0EFA','-1','backpack')
        uo.click('finditem')
        lag()
        if uo.injournal('0 spells') then
                uo.addobject('book','finditem')
                uo.charprint('0x0026','Object Book Adicionado')
        else
                uo.ignore('finditem')
        endif
until uo.injournal('0 spells')
endsub
########################################
#####FUNCAO PARA GUARDAR OS SCROLLS#####
########################################
Sub porScroll()
var i
DIM scroll[60]

scroll[1] = "0x1F2D" #reactve ar
scroll[2] = "0x1F2E" #clumsy
scroll[3] = "0x1F30" #fleeblemind
scroll[4] = "0x1F31" #heal
scroll[5] = "0x1F32" #ma
scroll[6] = "0x1F33" #night sight
scroll[7] = "0x1F34" #weaken
scroll[8] = "0x1F35" #agility
scroll[9] = "0x1F36" #cunning
scroll[10] = "0x1F37" #cure
scroll[11] = "0x1F38" #harm
scroll[12] = "0x1F39" #magictrap
scroll[13] = "0x1F3A" #magicuntrap
scroll[14] = "0x1F3B" #protection
scroll[15] = "0x1F3C" #strength
scroll[16] = "0x1F3D" #bless
scroll[17] = "0x1F3E" #fireball
scroll[18] = "0x1F3F" #magiclock
scroll[19] = "0x1F40" #poison
scroll[20] = "0x1F41" #telesinese
scroll[21] = "0x1F42" #teleport
scroll[22] = "0x1F43" #unlock
scroll[23] = "0x1F44" #wall of stone
scroll[24] = "0x1F45" #archcure
scroll[25] = "0x1F46" #archprot
scroll[26] = "0x1F48" #firefield
scroll[27] = "0x1F49" #great heal
scroll[28] = "0x1F4A" #lighting
scroll[29] = "0x1F4B" #manadrain
scroll[30] = "0x1F4C" #recall
scroll[31] = "0x1F4D" #blade spirit
scroll[32] = "0x1F4E" #dispel field
scroll[33] = "0x1F50" #magic reflection
scroll[34] = "0x1F51" #mind blast
scroll[35] = "0x1F52" #paralize
scroll[36] = "0x1F53" #poison field
scroll[37] = "0x1F54" #summon creature
scroll[38] = "0x1F55" #dispel
scroll[39] = "0x1F56" #eb
scroll[40] = "0x1F57" #explosion
scroll[41] = "0x1F58" #invisibility
scroll[42] = "0x1F59" #mark
scroll[43] = "0x1F5A" #masscurse
scroll[44] = "0x1F5B" #pf
scroll[45] = "0x1F5C" #reveal
scroll[46] = "0x1F5D" #chain light
scroll[47] = "0x1F5E" #energy field
scroll[48] = "0x1F5F" #fs
scroll[49] = "0x1F60" #gate
scroll[50] = "0x1F61" #manavampire
scroll[51] = "0x1F62" #massdispel
scroll[52] = "0x1F63" #meteorstorm
scroll[53] = "0x1F65" #earthquake
scroll[54] = "0x1F66" #energy vortex
scroll[55] = "0x1F67" #ressurection
scroll[56] = "0x1F68" #summon air
scroll[57] = "0x1F69" #summon daemon
scroll[58] = "0x1F6A" #summon earth
scroll[59] = "0x1F6B" #summon fire
scroll[60] = "0x1F6C" #summon water

for i = 1 to 60
        uo.findtype(scroll[i],'-1,','backpack')
        if uo.findcount() > 0 then
                repeat
                uo.moveitem('finditem','-1','book')
                wait(500)
            until NOT uo.count(scroll[i]) == 1
        endif
next
end sub
#####################################
#####FUNCAO PARA VERIFICAR O LAG#####
#####################################
Sub lag()
uo.deletejournal()
uo.click('backpack')
repeat
wait(1)
until uo.injournal('backpack')
end sub