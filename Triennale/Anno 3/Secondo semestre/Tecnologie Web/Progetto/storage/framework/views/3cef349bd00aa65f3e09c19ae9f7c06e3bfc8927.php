

<?php $__env->startSection('content'); ?>
    <!-- una hero image è un'area che viene particolarmente risaltata -->
    <div class="hero-image">
        <h1>Scontati ma non scontrosi: il momento perfetto per togliersi qualche sfizio</h1>
        <p>Promozioni da tantissime aziende</p>
        <a class="btn" href="<?php echo e(route('catalogo')); ?>">Inizia a sfogliare il catalogo</a>
    </div>

    <div class="container">
        <h2>Chi siamo e cosa facciamo</h2>
        <!-- desc contiene una descrizione della pagina visualizzata -->
        <div class="desc">
            <p class="emphatized-text">
                Siamo Offertopoli, un nuovo sito web che permette ai nostri clienti di ottenere coupons per usufruire dei migliori sconti offerti
                dalle aziende più importanti, di tutte le tipologie: dall'high tech, alla moda, per finire poi con la ristorazione e il mondo del cibo.<br><br>
                I nostri coupon sono liberamente stampabili e facili da usare; inoltre, per ogni coupon, mettiamo tutte le istruzioni in
                chiaro per poterlo usare nei negozi e in tutti i locali partecipanti.
            </p>
        </div>

        <h2>Alcune delle aziende associate</h2>
        <!-- le aziende vengono rappresentate graficamente come delle Card (carte), contenute in un Card Deck -->
        <div class="card-deck" title="Clicca su nome dell'azienda per saparne di più!!!">
            <?php $__currentLoopData = $Aziende; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $aziende): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                <div class="card">
                    <img src="data:image/png/jpg/webp/jpeg;base64,<?php echo e(base64_encode($aziende['logo'])); ?>" alt="Service Image" class="logo-azienda">
                    <a class="card-title-link" href="<?php echo e(route('dettagliAzienda', $aziende['id'])); ?>"><?php echo e($aziende['nome']); ?></a>
                </div>
            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
        </div>

        <h2>F.A.Q.</h2>
        <div class="toggle-list-mini">
            <p>Queste sono le domande più frequenti che gli utenti ci pongono. Clicca sulla domanda che ti interessa per scoprire la risposta!</p>
            <ul>
                <?php $__currentLoopData = $List; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $list): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                    <li>
                        <div class="toggle"><?php echo e($list['domanda']); ?></div>
                        <div class="hidden"><?php echo e($list['risposta']); ?></div>
                    </li>
                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
            </ul>
        </div>

        <h2>Documentazione del sito</h2>
        <br>
        <p>
            Tramite <a href="<?php echo e(asset('assets/tesina.pdf')); ?>">questo link</a> è possibile scaricare il documento in formato PDF che contiene la documentazione del sito web.
        </p>
    </div>

    <script type="text/javascript" src="<?php echo e(asset('assets/js/faq_viewer.js')); ?>"></script>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/homepage.blade.php ENDPATH**/ ?>