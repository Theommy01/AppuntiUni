

<?php $__env->startSection('title', 'Catalogo prodotti'); ?>

<?php $__env->startSection('content'); ?>
    <?php if(isset($FactoryQuery) or isset($OfferQuery)): ?>
        <div class="active-filters-container">
            Ricerca per:

            <?php if(isset($FactoryQuery)): ?>
                <span><strong><?php echo e($FactoryQuery); ?></strong></span>
            <?php endif; ?>

            <?php if(isset($OfferQuery)): ?>
                <span><em>"<?php echo e($OfferQuery); ?>"</em></span>
            <?php endif; ?>

            <span> - </span>
            <a href="<?php echo e(route('catalogo')); ?>">Reimposta</a>
        </div>
    <?php endif; ?>

    <div class="container container-with-aside">
        <aside>
            <div class="search-container search-container-aside">
                <a href="#" onclick="toggleSearchArea()" title="Clicca qui per effettuare una ricerca">
                    <img src="<?php echo e(asset('assets/images/search_offer.png')); ?>" alt="Apri sezione di ricerca" class="open-search-area">
                </a>

                <form id="catalog-search-form" method="POST" action="<?php echo e(route('catalogo')); ?>">
                    <?php echo csrf_field(); ?>
                    <h2>Ricerca per offerta</h2>
                    <input type="text" id="search-bar" name="offer_query" placeholder="Cerca un'offerta...">

                    <h2>Ricerca azienda</h2>
                    <input type="text" id="search-bar" name="factory_query" placeholder="Cerca un'azienda...">

                    <button type="submit" class="btn">Ricerca</button>
                </form>
            </div>
        </aside>

        <div id="section-offerte" class="card-deck">
            <?php if(count($Offerte) > 0): ?>
                <?php $__currentLoopData = $Offerte; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $offerte): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                    <div class="card">
                        <img src="data:image/png/jpg/webp/jpeg;base64,<?php echo e(base64_encode($offerte['logoAzienda'])); ?>" class="card-top-logo" alt="Logo azienda">
                        <img src="data:image/png/jpg/webp/jpeg;base64,<?php echo e(base64_encode($offerte['immagineOfferta'])); ?>" alt="Offerta">
                        <h3><?php echo e($offerte['nomeOfferta']); ?></h3>
                        <p><?php echo e($offerte['oggettoOfferta']); ?></p>
                        <a href="<?php echo e(url('/dettagliOfferta/'.$offerte['idOfferta'])); ?>" class="card-btn">Scopri di più</a>
                    </div>
                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
            <?php else: ?>
                <div class="notfound">
                    <img src="<?php echo e(asset('assets/images/notfound.jpg')); ?>" width="135" alt="Nessuna offerta trovata">
                    <p>Nessuna offerta trovata.</p>
                </div>
            <?php endif; ?>
        </div>
    </div>

    <?php echo $__env->make('pagination.paginator', ['pages' => $Offerte], \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>

    <script type="text/javascript" src="<?php echo e(asset('assets/js/popupSearch.js')); ?>"></script>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/catalogo.blade.php ENDPATH**/ ?>