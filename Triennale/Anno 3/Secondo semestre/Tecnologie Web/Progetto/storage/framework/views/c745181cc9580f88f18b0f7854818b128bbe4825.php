

<?php $__env->startSection('title', 'Lista delle aziende partecipanti'); ?>

<?php $__env->startSection('content'); ?>
    <div class="container">
        <h1>Lista delle aziende associate</h1>
        <div class="desc">
            <p>Questa è la lista di tutte le aziende associate a Offertopoli e che pubblicano offerte. Clicca su un'azienda per
                scoprirne tutti i dettagli.</p>
        </div>

        <div class="search-container">
            <form id="search-form" method="POST" action="<?php echo e(route('aziende')); ?>">
                <?php echo csrf_field(); ?>
                <div class="search-wrapper">
                    <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                    <input type="text" id="search-bar" name="query" placeholder="Cerca un'azienda..."
                           title="Cerca un'azienda scrivendo qui e poi premendo il taSto INVIO/ENTER">

                    <button type="submit">
                        <img src="<?php echo e(asset("assets/images/search.svg")); ?>" alt="Cerca">
                    </button>
                </div>
            </form>

            <?php if(isset($searchQuery)): ?>
            <div class="active-filters-container">
                Ricerca per:

                <?php if(isset($searchQuery)): ?>
                    <span><em>"<?php echo e($searchQuery); ?>"</em></span>
                <?php endif; ?>

                <span> - </span>
                <a href="<?php echo e(route('aziende')); ?>">Reimposta</a>
            </div>
            <?php endif; ?>
        </div>

        <div id="section-offerte" class="card-deck">
            <?php if(count($Aziende) > 0): ?>
                <?php $__currentLoopData = $Aziende; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $aziende): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                    <div class="card" title="Clicca su nome dell'azienda per saparne di più!!!">
                        <img src="data:image/png/jpeg;base64,<?php echo e(base64_encode($aziende['logo'])); ?>" alt="Logo di un'azienda" class="logo-azienda">
                        <a class="card-title-link" href="<?php echo e(route('dettagliAzienda', $aziende['id'])); ?>"><?php echo e($aziende['nome']); ?></a>
                    </div>
                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
            <?php else: ?>
                <div class="notfound">
                    <img src="<?php echo e(asset('assets/images/notfound.jpg')); ?>" width="135" alt="Nessuna azienda trovata">
                    <p>Nessuna azienda trovata.</p>
                </div>
            <?php endif; ?>
        </div>

        <?php echo $__env->make('pagination.paginator', ['pages' => $Aziende], \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
    </div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/aziende.blade.php ENDPATH**/ ?>