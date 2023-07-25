

<?php $__env->startSection('title', 'Gestione delle offerte'); ?>

<?php $__env->startSection('content'); ?>
    <div class="container">
        <div class="panel">
            <h2>Gestione Offerte</h2>

            <div class="search-container">
                <form id="search-form" method="POST" action="<?php echo e(route('gestioneOfferte')); ?>">
                    <?php echo csrf_field(); ?>
                    <div class="search-wrapper">
                        <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                        <input type="text" id="search-bar" name="query" placeholder="Cerca un'offerta..." title="Cerca un'offerta scrivendo qui e poi premendo il tasto INVIO/ENTER">
                        <button type="submit"><img src="<?php echo e(asset("assets/images/search.svg")); ?>" alt="Cerca"></button>
                    </div>
                </form>
            </div>

            <table class="tabella insert-element-table">
                <tbody>
                    <tr>
                        <td class="insert-element-desc">Vuoi inserire una nuova Offerta?</td>
                        <td class="insert-element-btn-container">
                            <a href="<?php echo e(route('inserisciOfferte')); ?>" class="btn btn-FAQ">Inserisci</a>
                        </td>
                    </tr>
                </tbody>
            </table>

            <br>
            <br>
            <table class="tabella">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Modifica</th>
                        <th>Elimina</th>
                    </tr>
                </thead>

                <tbody>
                <?php $__currentLoopData = $List; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $list): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                    <tr>
                        <td><?php echo e($list['id']); ?></td>
                        <td><?php echo e($list['nome']); ?></td>
                        <td title="Clicca qui per AGGIORNARE la seguente offerta"><a class="btn-table-update" href="<?php echo e(route('aggiornaOfferte', $list['id'])); ?>">Modifica</a></td>
                        <td title="Clicca qui per ELIMINARE la seguente offerta">
                            <form class="delete-form" action="<?php echo e(route('eliminaOfferte', $list['id'])); ?>" method="POST">
                                <?php echo csrf_field(); ?>
                                <?php echo method_field('DELETE'); ?>
                                <button type="submit" class="btn-table-delete" onclick="return confirm('Sei sicuro di voler eliminare questa offerta?')">
                                    Elimina</button>
                            </form>
                        </td>
                    </tr>
                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                </tbody>
            </table>

            <div class="panel-buttons">
                <a class="btn btn-back" href="<?php echo e(route('hubUtente')); ?>">Torna indietro</a>
            </div>
        </div>
    </div>
<?php $__env->stopSection(); ?>


<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/staff/gestioneOfferte.blade.php ENDPATH**/ ?>