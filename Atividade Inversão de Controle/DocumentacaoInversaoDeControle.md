Universidade.java

    Atua como a implementação concreta da interface Observer. Ela representa o código customizado pelo desenvolvedor que "reage" aos eventos disparados pelo sistema.

Interface Observer.java

    Funciona como o "gancho" (hook) do framework. Ela define a assinatura do método de callback que o framework utilizará para devolver o controle ao código do usuário.

Classe Subject.java

    É o núcleo do Framework. Ela mantém a lista de interessados e implementa a lógica genérica de notificação. Ela não conhece as classes concretas (como Universidade), apenas a interface, garantindo o baixo acoplamento.

Classe PCD.java

    Especializa o Subject com dados específicos. Ela é a responsável por disparar o gatilho de notificação, mas a "inteligência" de como distribuir essa informação permanece na superclasse Subject.

A Inversão de Controle (IoC)

    O padrão é regido pelo "Princípio de Hollywood": “Não nos chame, nós chamaremos você”.

    No código: As instâncias de Universidade não ficam perguntando ao PCD se os dados mudaram. Em vez disso, elas "esperam" passivamente que o framework (Subject) as invoque através do método update. O controle do fluxo de execução sai das mãos do objeto observador e passa para o framework.