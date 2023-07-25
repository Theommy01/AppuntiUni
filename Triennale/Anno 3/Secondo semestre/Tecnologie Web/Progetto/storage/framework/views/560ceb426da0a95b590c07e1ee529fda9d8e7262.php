

<?php $__env->startSection('title', "'Dettagli dell'azienda"); ?>

<?php $__env->startSection('content'); ?>
    <div class="container">
        <div class="panel">
            <?php if(isset($tuple)): ?>
            <div class="title-with-logo">
                <img src="data:image/png/jpeg;base64,<?php echo e(base64_encode($tuple['logo'])); ?>" alt="Logo Azienda" class="logo-azienda">
                <h2><?php echo e($tuple['nome']); ?></h2>
            </div>

            <div class="toggle-list">
                <p class="toggle-list-hint">Clicca sui titoli per espandere i contenitori dei dettagli</p>
                <ul>
                    <li class="toggle" title="Clicca qui per saperne di più!"><h2>Descrizione</h2>
                        <ul class="sub-list hidden">
                            <li><p><?php echo e($tuple['descrizione']); ?></p></li>
                        </ul>
                    </li>
                    <li class="toggle" title="Clicca qui per saperne di più!"><h2>Tipologia</h2>
                        <ul class="sub-list hidden">
                            <li><p><?php echo e($tuple['tipologia']); ?></p></li>
                        </ul>
                    </li>
                    <li class="toggle" title="Clicca qui per saperne di più!"><h2>Ragione Sociale</h2>
                        <ul class="sub-list hidden">
                            <li><p><?php echo e($tuple['ragioneSociale']); ?></p></li>
                        </ul>
                    </li>
                    <li class="toggle" title="Clicca qui per saperne di più!"><h2>Dove si trova</h2>
                        <ul class="sub-list hidden">
                            <li><p><?php echo e($tuple['localizzazione']); ?></p></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <?php else: ?>
            <p>Errore: l'azienda richiesta non è disponibile sul database.</p>
            <?php endif; ?>

            <div class="panel-buttons">
                <a class="btn" href="<?php echo e(route('aziende')); ?>">Torna alla lista delle aziende</a><br><br>
            </div>
        </div>

        <script type="text/javascript" src="<?php echo e(asset('assets/js/toggleListManager.js')); ?>"></script>
    </div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/dettagliAzienda.blade.php ENDPATH**/ ?>